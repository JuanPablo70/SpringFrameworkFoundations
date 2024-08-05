package com.juan.sanchez.config.repository;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("p1")
public class RepositoryP1Config {

    @Bean
    BookRepository createBookRepository(DataSource dataSource){
        return new BookJdbcRepository(dataSource);
    }

}
