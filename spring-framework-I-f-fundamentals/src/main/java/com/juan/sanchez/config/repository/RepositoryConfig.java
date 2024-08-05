package com.juan.sanchez.config.repository;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookP1JdbcRepository;
import com.juan.sanchez.repository.jdbc.BookP2JdbcRepository;
import com.juan.sanchez.repository.jdbc.BookP3JdbcRepository;
import com.juan.sanchez.repository.jdbc.BookP4JdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
class RepositoryConfig {

    @Profile("p1")
    @Bean(name="bookRepository")
    BookRepository bookRepositoryP1(DataSource dataSource) {
        return new BookP1JdbcRepository(dataSource);
    }

    @Profile("p2")
    @Bean(name="bookRepository")
    BookRepository bookRepositoryP2(DataSource dataSource) {
        return new BookP2JdbcRepository(dataSource);
    }

    @Profile("p3")
    @Bean(name="bookRepository",
            initMethod="afterPropertiesSet", destroyMethod="destroy")
    BookRepository bookRepositoryP3(DataSource dataSource) {
        return new BookP3JdbcRepository(dataSource);
    }

    @Profile("p4")
    @Bean(name="bookRepository")
    BookRepository bookRepositoryP4(DataSource dataSource) {
        return new BookP4JdbcRepository(dataSource);
    }

}
