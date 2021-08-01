package hu.ulyssys.java.course.javaee.demo.twitter.service;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.AbstractTwitter;

import java.util.List;

public interface CoreService<T extends AbstractTwitter> {
    List<T> getAll();

    void add(T twitter);

    void remove(T twitter);

    void update(T twitter);
}
