package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("p3")
class ServiceP3Config {

    private BookRepository bookRepository;

    @Autowired
    @Qualifier("createBookRepositoryA")
    void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Bean(name="bookService", initMethod ="beanNameForBookRepository")
    BookService createBookService() {
        return new BookServiceImpl(bookRepository);
    }

}
