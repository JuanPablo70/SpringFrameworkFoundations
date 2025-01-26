package com.juan.sanchez.config.infrastructure;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@TestPropertySource(locations={"classpath:/com/juan/sanchez/mysql/v1/mysql-test.properties"}) //It's recommended to not use it in an infrastructure class
class InfrastructureMysqlTestConfig {

    @Autowired
    private Environment env;

    @Bean
    @Profile("pre-prod")
    DataSource dataSourceMysqlTest() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl());
            dataSource.setUser(env.getProperty("db.user"));
            dataSource.setPassword(env.getProperty("db.password"));
            dataSource.setServerTimezone(env.getProperty("db.timezone"));
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            propertiesReport();
        }
        return dataSource;
    }

    private String getUrl(){
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://")
                .append(env.getProperty("db.ip", String.class))
                .append(":")
                .append(env.getProperty("db.port", Integer.class))
                .append("/")
                .append(env.getProperty("db.name", String.class))
                .append("?allowPublicKeyRetrieval=true&useSSL=false");
        return sb.toString();
    }

    private void propertiesReport() {
        System.out.println("Properties Report Test I");
        System.out.println(" app.name   :" + env.getProperty("app.name"));
        System.out.println(" host.name  :" + env.getProperty("host.name"));
        System.out.println(" host.ipv4  :" + env.getProperty("host.ipv4"));
        System.out.println(" host.ipv6  :" + env.getProperty("host.ipv6"));
        System.out.println(" host.ipv6  :" + env.getProperty("host.ipv6", "not defined"));
        System.out.println(" host.ipv6  :" + env.getProperty("host.ipv6", String.class, "not defined"));
        System.out.println(" db.name    :" + env.getProperty("db.name", String.class));
        System.out.println(" db.ip      :" + env.getProperty("db.ip", String.class));
        System.out.println(" db.port    :" + env.getProperty("db.port", Integer.class));
        System.out.println(" db.user    :" + env.getProperty("db.user"));
        System.out.println(" db.password:" + env.getProperty("db.password"));
        System.out.println(" db.timezone:" + env.getProperty("db.timezone"));
    }

}
