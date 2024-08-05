package com.juan.sanchez.config.service;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("p4")
class ServiceP4Config {

    @Bean(name="bookService", initMethod ="beanNameForBookRepository")
    BookService createBookService(@Qualifier("createBookRepositoryB") BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

}
