package com.juan.sanchez.main;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("Main - 'spring-framework-III-a-fundamentals' - Start");
        System.out.println("****************************************");

        // Creates the beans in AppConfig
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Optional.ofNullable(System.getProperty("spring.application.context.report"))
                .ifPresent(t -> {
                    if(t.equals("true")) {
                        SpringFrameworkUtils.profilesAndBeansDefinitionsReport(ctx);
                    }
                });

        try {
            ctx.getBean(DataSource.class);
        } catch(NoUniqueBeanDefinitionException ex) {
            System.out.println("*********************************************");
            System.out.println("Exception - Exception - Exception - Exception");
            System.out.println("*********************************************");
            System.out.println("Exception Type: " + ex.getClass());
            System.out.println("Exception BeanNames Found: " + ex.getBeanNamesFound().size());
            System.out.println("Exception BeanNames Found: " + ex.getBeanNamesFound());
            System.out.println("Exception Message: " + ex.getMessage());
            System.out.println("*********************************************");
            System.out.println("Exception - Exception - Exception - Exception");
            System.out.println("*********************************************");
        }

        if(Stream.of(ctx.getEnvironment().getActiveProfiles())
                .filter(p -> p.equals("business")).count() == 0 ) {
            return ;
        }

        // Gets the bean that returns BookService
        BookService bookService = ctx.getBean(BookService.class);

        System.out.println("");
        System.out.println("--------------------");
        System.out.println("Report - 'findById'");
        System.out.println("--------------------");
        System.out.println("");
        bookService.report(bookService.findById(1));
        bookService.report(bookService.findById(15));
        bookService.report(bookService.findById(27));

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("Report - 'findAll'");
        System.out.println("-------------------");
        System.out.println("");
        bookService.report(bookService.findAll());

        System.out.println("");
        System.out.println("----------------------");
        System.out.println("Report - 'count'");
        System.out.println("----------------------");
        System.out.println("");
        bookService.report(bookService.count());

        Optional.ofNullable(System.getProperty("spring.application.context.report"))
                        .ifPresent(t -> {
                            if (t.equals("true")) {
                                SpringFrameworkUtils.profilesAndBeansDefinitionsReport(ctx);
                            }
                        });
        ctx.close();

        System.out.println("");
        System.out.println("*************************************");
        System.out.println("Main - 'spring-framework-III-a-fundamentals' - End");
        System.out.println("*************************************");
    }
}