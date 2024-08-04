package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ServiceConfig {

    @Bean
    BookService createBookService(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

}
