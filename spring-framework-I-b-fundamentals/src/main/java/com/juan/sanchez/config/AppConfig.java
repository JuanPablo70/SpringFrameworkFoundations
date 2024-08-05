package com.juan.sanchez.config;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Import({InfrastructureConfig.class, BusinessConfig.class})
public class AppConfig {

//    @Bean
//    DataSource dataSourceMysql() {
//        MysqlDataSource dataSource = null;
//        try {
//            dataSource = new MysqlDataSource();
//            dataSource.setUrl(getUrl());
//            dataSource.setUser("XXX");
//            dataSource.setPassword("XXX");
//            dataSource.setServerTimezone("UTC");
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        }
//        return dataSource;
//    }
//
//    @Bean
//    BookRepository createBookRepository() {
//        return new BookJdbcRepository(dataSourceMysql());
//    }
//
//    @Bean
//    BookService createBookService() {
//        return new BookServiceImpl(createBookRepository());
//    }
//
//    private String getUrl(){
//        return "jdbc:mysql://<IP>:<Puerto>/<Database>" +
//                "?allowPublicKeyRetrieval=true&useSSL=false";
//    }

}
