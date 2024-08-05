package com.juan.sanchez.config.repository;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
class RepositoryConfig {

    @Bean
    @Profile("repoA")
    BookRepository createBookRepositoryA(DataSource dataSource) {
        return new BookJdbcRepository(dataSource, "bookRepositoryA");
    }

    @Bean
    @Profile("repoB")
    BookRepository createBookRepositoryB(DataSource dataSource) {
        return new BookJdbcRepository(dataSource, "bookRepositoryB");
    }

}
