package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
class ServiceConfig {

    @Profile("p1")
    @Bean(name="bookService")
    BookService bookServiceP1(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

    @Profile("p2")
    @Scope("singleton")
    @Bean(name="bookService")
    BookService bookServiceP2(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

    @Profile("p3")
    @Scope("prototype")
    @Bean(name="bookService")
    BookService bookServiceP3(BookRepository bookRepository){
        return new BookServiceImpl(bookRepository);
    }

}
