package com.juan.sanchez.config.repository;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("p2")
public class RepositoryP2Config {

    @Autowired
    private DataSource dataSource;

    @Bean
    BookRepository createBookRepository(){
        return new BookJdbcRepository(dataSource);
    }

}
