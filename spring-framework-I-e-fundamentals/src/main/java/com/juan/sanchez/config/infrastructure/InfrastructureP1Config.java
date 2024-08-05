package com.juan.sanchez.config.infrastructure;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Profile("p1")
@PropertySource({"classpath:/com/juan/sanchez/app/app.properties",
        "classpath:/com/juan/sanchez/host/host.properties"})
@PropertySource({"classpath:/com/juan/sanchez/mysql/v1/mysql.properties"})
class InfrastructureP1Config {

    @Autowired
    private Environment env;

    @Bean
    DataSource dataSourceMysql() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl());
            dataSource.setUser(env.getProperty("db.user"));
            dataSource.setPassword(env.getProperty("db.password"));
            dataSource.setServerTimezone(env.getProperty("db.timezone"));
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            reportProperties();
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

    private void reportProperties() {
        System.out.println("Properties Report");
        System.out.println(" app.name :" + env.getProperty("app.name"));
        System.out.println(" host.name :" + env.getProperty("host.name"));
        System.out.println(" host.ipv4 :" + env.getProperty("host.ipv4"));
        System.out.println(" host.ipv6 :" + env.getProperty("host.ipv6"));
        System.out.println(" host.ipv6 :" + env.getProperty("host.ipv6", "not defined"));
        System.out.println(" host.ipv6 :" + env.getProperty("host.ipv6", String.class, "not defined"));
        System.out.println(" db.name :" + env.getProperty("db.name", String.class));
        System.out.println(" db.ip :" + env.getProperty("db.ip", String.class));
        System.out.println(" db.port :" + env.getProperty("db.port", Integer.class));
        System.out.println(" db.user :" + env.getProperty("db.user"));
        System.out.println(" db.password:" + env.getProperty("db.password"));
        System.out.println(" db.timezone:" + env.getProperty("db.timezone"));
    }

    @SuppressWarnings("unused")
    private static PropertySourcesPlaceholderConfigurer pspConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
