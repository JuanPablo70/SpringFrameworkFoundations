package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("p2")
class ServiceP2Config {

    private final BookRepository bookRepository;

    ServiceP2Config(@Qualifier("createBookRepositoryB") BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Bean(name="bookService", initMethod ="beanNameForBookRepository")
    BookService createBookService() {
        return new BookServiceImpl(bookRepository);
    }

}
