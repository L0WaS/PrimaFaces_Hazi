package hu.ulyssys.java.course.javaee.demo.twitter.service.impl;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.Author;
import hu.ulyssys.java.course.javaee.demo.twitter.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
public class AuthorServiceImpl extends AbstractServiceImpl<Author> implements AuthorService {

    public AuthorServiceImpl() {

        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setId(Long.parseLong(i+""));
            author.setUsername("User"+i);
            author.setFirstName("Krisztián");
            author.setLastName("Berki");
            Date date = new Date(System.currentTimeMillis());
            author.setCreatedDate(date);
            author.setLastModifiedDate(date);
            add(author);
        }
    }

    @Override
    public void update(Author twitter) {
        for (Author author : getAll()) {
            if(author.getId().equals(twitter.getId())){
                author.setUsername(twitter.getUsername());
                author.setFirstName(twitter.getFirstName());
                author.setLastName(twitter.getLastName());
                author.setCreatedDate(twitter.getCreatedDate());
                author.setLastModifiedDate(twitter.getLastModifiedDate());
                break;
            }
        }
    }
}
