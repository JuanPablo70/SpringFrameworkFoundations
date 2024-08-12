package com.juan.sanchez.service.impl;

import com.juan.sanchez.service.CacheService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("business")
class NotFunctionalCacheService implements CacheService<Object, Object> {

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public Object get(Object o) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public void report() {
        throw new UnsupportedOperationException("Operation not implemented");
    }

}
