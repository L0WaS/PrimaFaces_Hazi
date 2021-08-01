package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.BlogPost;
import hu.ulyssys.java.course.javaee.demo.twitter.service.BlogPostService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class BlogPostCRUDMbean implements Serializable {

    private List<BlogPost> list;
    private BlogPost selectedBlogPost;

    private boolean inFunction;

    private BlogPostService blogPostService;


    @Inject
    public BlogPostCRUDMbean(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
        list = blogPostService.getAll();
        selectedBlogPost = new BlogPost();
    }

    public void initSave() {
        selectedBlogPost = new BlogPost();
        inFunction = true;
    }

    public void initEdit(BlogPost blogPost) {
        selectedBlogPost = blogPost;
        inFunction = true;
    }

    public void save() {
        if (selectedBlogPost.getId() == null) {
            Date date2 = new Date(System.currentTimeMillis());
            selectedBlogPost.setId(System.currentTimeMillis());
            selectedBlogPost.setLastModifiedDate(date2);
            selectedBlogPost.setCreatedDate(date2);
            blogPostService.add(selectedBlogPost);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            blogPostService.update(selectedBlogPost);
            Date date3 = new Date(System.currentTimeMillis());
            selectedBlogPost.setLastModifiedDate(date3);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        inFunction = false;
    }

    public void remove(BlogPost blogPost) {
        blogPostService.remove(blogPost);
        list = blogPostService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));

    }

    public List<BlogPost> getList() {
        return list;
    }

    public void setList(List<BlogPost> list) {
        this.list = list;
    }

    public BlogPost getSelectedBlogPost() {
        return selectedBlogPost;
    }

    public void setSelectedBlogPost(BlogPost selectedBlogPost) {
        this.selectedBlogPost = selectedBlogPost;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
