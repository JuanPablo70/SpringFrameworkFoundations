package com.juan.sanchez.config.repository;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class RepositoryConfig {

    @Bean
    BookRepository createBookRepository(DataSource dataSource) {
        return new BookJdbcRepository(dataSource);
    }

}
