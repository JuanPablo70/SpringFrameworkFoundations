package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookP1ServiceImpl;
import com.juan.sanchez.service.impl.BookP2ServiceImpl;
import com.juan.sanchez.service.impl.BookP3ServiceImpl;
import com.juan.sanchez.service.impl.BookP4ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class ServiceConfig {

    @Profile("p1")
    @Bean(name="bookService")
    BookService bookServiceP1(BookRepository bookRepository){
        return new BookP1ServiceImpl(bookRepository);
    }

    @Profile("p2")
    @Bean(name="bookService")
    BookService bookServiceP2(BookRepository bookRepository){
        return new BookP2ServiceImpl(bookRepository);
    }

    @Profile("p3")
    @Bean(name="bookService",
            initMethod="afterPropertiesSet", destroyMethod="destroy")
    BookService bookServiceP3(BookRepository bookRepository){
        return new BookP3ServiceImpl(bookRepository);
    }

    @Profile("p4")
    @Bean(name="bookService")
    BookService bookServiceP4(BookRepository bookRepository){
        return new BookP4ServiceImpl(bookRepository);
    }

}
