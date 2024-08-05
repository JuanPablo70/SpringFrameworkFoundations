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
@Profile("p3")
@PropertySource({"classpath:/com/juan/sanchez/app/app.properties",
        "classpath:/com/juan/sanchez/host/host.properties"})
@PropertySource({"classpath:/com/juan/sanchez/mysql/v1/mysql.properties"})
public class InfrastructureP3Config {

    @Bean
    DataSource dataSourceMysql(
            @Value("${app.name}") String appName,
            @Value("${host.name}") String hostName,
            @Value("${host.ipv4}") String hostIpv4,
            @Value("${host.ipv6}") String hostIpv6,
            @Value("${db.name}") String dbName,
            @Value("${db.ip}") String dbIp,
            @Value("${db.port}") int dbPort,
            @Value("${db.user}") String dbUser,
            @Value("${db.password}") String dbPassword,
            @Value("${db.timezone}") String dbTimezone) {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl(dbIp, dbPort, dbName));
            dataSource.setUser(dbUser);
            dataSource.setPassword(dbPassword);
            dataSource.setServerTimezone(dbTimezone);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            reportProperties(appName, hostName, hostIpv4, hostIpv6,
                    dbName, dbIp, dbPort, dbUser, dbPassword, dbTimezone);

        }
        return dataSource;
    }

    private String getUrl(String dbIp, int dbPort, String dbName){
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

    private void reportProperties(
            String appName,
            String hostName, String hostIpv4, String hostIpv6,
            String dbName, String dbIp, int dbPort,
            String dbUser, String dbPassword, String dbTimezone) {
        System.out.println("Properties Report");
        System.out.println(" app.name :" + appName);
        System.out.println(" host.name :" + hostName);
        System.out.println(" host.ipv4 :" + hostIpv4);
        System.out.println(" host.ipv6 :" + hostIpv6.toString());
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
