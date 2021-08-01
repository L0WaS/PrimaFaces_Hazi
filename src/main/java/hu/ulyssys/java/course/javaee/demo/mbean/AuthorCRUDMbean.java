package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.Author;
import hu.ulyssys.java.course.javaee.demo.twitter.service.AuthorService;

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
public class AuthorCRUDMbean implements Serializable {

    private List<Author> list;
    private Author selectedAuthor;

    private boolean inFunction;

    private AuthorService authorService;


    @Inject
    public AuthorCRUDMbean(AuthorService authorService) {
        this.authorService = authorService;
        list = authorService.getAll();
        selectedAuthor = new Author();
    }

    public void initSave() {
        selectedAuthor = new Author();
        inFunction = true;
    }

    public void initEdit(Author author) {
        selectedAuthor = author;
        inFunction = true;
    }

    public void save() {
        if (selectedAuthor.getId() == null) {
            Date date2 = new Date(System.currentTimeMillis());
            selectedAuthor.setId(System.currentTimeMillis());
            selectedAuthor.setLastModifiedDate(date2);
            selectedAuthor.setCreatedDate(date2);
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            authorService.update(selectedAuthor);
            Date date3 = new Date(System.currentTimeMillis());
            selectedAuthor.setLastModifiedDate(date3);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        inFunction = false;
    }

    public void remove(Author author) {
        authorService.remove(author);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));

    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
