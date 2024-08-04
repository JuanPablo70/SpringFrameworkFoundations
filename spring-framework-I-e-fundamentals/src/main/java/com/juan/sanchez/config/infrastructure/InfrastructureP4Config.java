package com.juan.sanchez.config.infrastructure;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Profile("p4")
@PropertySource({"classpath:/com/juan/sanchez/app/app.properties",
        "classpath:/com/juan/sanchez/host/host.properties"})
@PropertySource({"classpath:/com/juan/sanchez/mysql/v1/mysql.properties"})
public class InfrastructureP4Config {

    @Value("#{environment['app.name']}")
    private String appName;

    @Value("#{environment['host.name']}")
    private String hostName;

    @Value("#{environment['host.ipv4']}")
    private String hostIpv4;

    @Value("#{environment['host.ipv6']}")
    private String hostIpv6;

    @Value("#{environment['db.name']}")
    private String dbName;

    @Value("#{environment['db.ip']}")
    private String dbIp;

    /**
     * Equivalences:
     *
     * <ul>
     * <li><code>@Value("#{environment['db.port']}")</code></li>
     * <li><code>@Value("#{new java.lang.Integer(environment['db.port'])}")</code></li>
     * <li><code>@Value("#{T(java.lang.Integer).parseInt(environment['db.port'])}")</code></li>
     * </ul>
     *
     */
    @Value("#{environment['db.port']}")
    private int dbPort;

    @Value("#{environment['db.user']}")
    private String dbUser;

    @Value("#{environment['db.password']}")
    private String dbPassword;

    @Value("#{environment['db.timezone']}")
    private String dbTimezone;

    @Bean
    DataSource dataSourceMysql() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl());
            dataSource.setUser(dbUser);
            dataSource.setPassword(dbPassword);
            dataSource.setServerTimezone(dbTimezone);
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
                .append(dbIp)
                .append(":")
                .append(dbPort)
                .append("/")
                .append(dbName)
                .append("?allowPublicKeyRetrieval=true&useSSL=false");
        return sb.toString();

    }

    private void reportProperties() {
        System.out.println("Properties Report");
        System.out.println(" app.name :" + appName);
        System.out.println(" host.name :" + hostName);
        System.out.println(" host.ipv4 :" + hostIpv4);
        System.out.println(" host.ipv6 :" + hostIpv6);
        System.out.println(" db.name :" + dbName);
        System.out.println(" db.ip :" + dbIp);
        System.out.println(" db.port :" + dbPort);
        System.out.println(" db.user :" + dbUser);
        System.out.println(" db.password:" + dbPassword);
        System.out.println(" db.timezone:" + dbTimezone);
    }

    @SuppressWarnings("unused")
    private static PropertySourcesPlaceholderConfigurer pspConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
