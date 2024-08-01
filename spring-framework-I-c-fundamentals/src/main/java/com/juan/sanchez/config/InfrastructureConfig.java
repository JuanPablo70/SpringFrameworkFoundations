package com.juan.sanchez.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
class InfrastructureConfig {

    @Bean
    DataSource dataSourceMysql() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl());
            dataSource.setUser("XXX");
            dataSource.setPassword("XXX");
            dataSource.setServerTimezone("UTC");
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    private String getUrl(){
        return "jdbc:mysql://<IP>:<Puerto>/<Database>" +
                "?allowPublicKeyRetrieval=true&useSSL=false";
    }

}
