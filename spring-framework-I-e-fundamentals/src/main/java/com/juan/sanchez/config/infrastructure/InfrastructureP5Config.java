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
@Profile("p5")
@PropertySource({"classpath:/com/juan/sanchez/app/app.properties",
        "classpath:/com/juan/sanchez/host/host.properties"})
@PropertySource({"classpath:/com/juan/sanchez/mysql/v1/mysql.properties"})
public class InfrastructureP5Config {

    @Bean
    DataSource dataSourceMysql(
            @Value("#{environment['app.name']}") String appName,
            @Value("#{environment['host.name']}") String hostName,
            @Value("#{environment['host.ipv4']}") String hostIpv4,
            @Value("#{environment['host.ipv6'] ?: 'not defined'}") String hostIpv6,
            @Value("#{environment['db.name']}") String dbName,
            @Value("#{environment['db.ip']}") String dbIp,
            @Value("#{environment['db.port']}") int dbPort,
            @Value("#{environment['db.user']}") String dbUser,
            @Value("#{environment['db.password']}") String dbPassword,
            @Value("#{environment['db.timezone']}") String dbTimezone) {
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
