package com.juan.sanchez.config;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class BusinessConfig {

    @Bean
    BookRepository createBookRepository(DataSource dataSource) {
        return new BookJdbcRepository(dataSource);
    }

    @Bean
    BookService createBookService(DataSource dataSource) {
        return new BookServiceImpl(createBookRepository(dataSource));
    }

}
