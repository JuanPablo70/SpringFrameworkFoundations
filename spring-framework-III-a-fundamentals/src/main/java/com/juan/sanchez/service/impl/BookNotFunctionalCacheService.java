package com.juan.sanchez.service.impl;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.CacheService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("business")
public class BookNotFunctionalCacheService implements CacheService<Book, Integer> {

    @Override
    public boolean add(Book book) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public Book get(Integer id) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public void report() {
        throw new UnsupportedOperationException("Operation not implemented");
    }

}
