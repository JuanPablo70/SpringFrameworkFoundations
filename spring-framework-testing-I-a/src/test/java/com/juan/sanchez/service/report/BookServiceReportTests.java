package com.juan.sanchez.service.report;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing Multiple 'report' Test Methods")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceReportTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private ConfigurableApplicationContext ctx;

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
