package hu.ulyssys.java.course.javaee.demo.twitter.service.impl;

import hu.ulyssys.java.course.javaee.demo.twitter.entity.AbstractTwitter;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractServiceImpl<T extends AbstractTwitter> {
    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T twitter) {
        list.add(twitter);
    }

    public void remove(T twitter) {
        list.remove(twitter);
    }

}