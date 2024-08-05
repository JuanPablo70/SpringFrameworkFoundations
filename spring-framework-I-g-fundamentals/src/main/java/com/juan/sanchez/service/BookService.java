package com.juan.sanchez.service;

import com.juan.sanchez.domain.Book;

import java.util.Collection;

public interface BookService {

    void setDefaultId(int defaultId);
    Book save(Book book);
    Book findById(int id);
    Book findByDefaultId();
    Collection<Book> findAll();
    long count();
    Book update(Book book);
    void delete(int id);
    void report(Book book);
    void report(Collection<Book> books);
    void report(long count);

}
