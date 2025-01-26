package com.juan.sanchez.service.report.testpropertysource;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ActiveProfiles({"pre-prod","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@TestPropertySource(locations={"classpath:/com/juan/sanchez/mysql/v1/mysql-test.properties"},
        properties={"db.ip=XXX.XXX.XXX.XXX","db.port=330XXX",
                "host.ipv6:aaabbbccc","app.country Colombia",
                "host.ipv4=XXX.XXX.XXX.XXX"})
@DisplayName("Testing Multiple 'report' Test Methods")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceReportTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Autowired
    private Environment env;

    @Test
    @Order(1)
    @DisplayName("Testing Report - 'findById'")
    void reportFindByIdTest() {
        System.out.println("--------------------");
        System.out.println("Report - 'findById'");
        System.out.println("--------------------");
        bookService.report(bookService.findById(1));
        bookService.report(bookService.findById(5));
        bookService.report(bookService.findById(7));
    }

    @Test
    @Order(2)
    @DisplayName("Testing Report - 'findAll'")
    void reportFindAllTest() {
        System.out.println("-------------------");
        System.out.println("Report - 'findAll'");
        System.out.println("-------------------");
        bookService.report(bookService.findAll());
    }

    @Test
    @Order(3)
    @DisplayName("Testing Report - 'count'")
    void reportCountTest() {
        System.out.println("-----------------");
        System.out.println("Report - 'count'");
        System.out.println("-----------------");
        bookService.report(bookService.count());
    }

    @Test
    @Order(4)
    @DisplayName("Testing Report - 'Spring ApplicationContext'")
    void reportSpringApplicationContextTest() {
        assumeTrue(System.getProperty("spring.application.context.report") != null &&
                        System.getProperty("spring.application.context.report").equals("true"),
                () -> assumptionMessage());

        SpringFrameworkUtils.profilesAndBeansDefinitionsReport(ctx);
        propertiesReport();
    }

    private void propertiesReport() {
        System.out.println("Properties Report Test II");
        System.out.println(" app.name   :" + env.getProperty("app.name"));
        System.out.println(" app.country:" + env.getProperty("app.country"));
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

    private String assumptionMessage() {
        try {
            TimeUnit.SECONDS.sleep(6);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        return "-Dspring.application.context.report is not 'true'";
    }

}
