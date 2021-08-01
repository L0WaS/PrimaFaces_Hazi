package hu.ulyssys.java.course.javaee.demo.twitter.service.impl;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.BlogPost;
import hu.ulyssys.java.course.javaee.demo.twitter.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class BlogPostServiceImpl extends AbstractServiceImpl<BlogPost> implements BlogPostService {

    public BlogPostServiceImpl() {

        for (int i = 0; i < 100; i++) {
            BlogPost blogPost = new BlogPost();
            blogPost.setId(Long.parseLong(i+""));
            blogPost.setTitle("Cím"+i);
            blogPost.setContent("Tartaloom");
            Date date = new Date(System.currentTimeMillis());
            blogPost.setCreatedDate(date);
            blogPost.setLastModifiedDate(date);
            add(blogPost);
        }
    }

    @Override
    public void update(BlogPost twitter) {
        for (BlogPost blogPost : getAll()) {
            if(blogPost.getId().equals(twitter.getId())){
                blogPost.setTitle(twitter.getTitle());
                blogPost.setContent(twitter.getContent());
                blogPost.setCategory(twitter.getCategory());
                blogPost.setCreatedDate(twitter.getCreatedDate());
                blogPost.setLastModifiedDate(twitter.getLastModifiedDate());
                blogPost.setPublishedDate(twitter.getPublishedDate());
                break;
            }
        }
    }
}
