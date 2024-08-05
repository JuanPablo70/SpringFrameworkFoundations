package com.juan.sanchez.main;

import com.juan.sanchez.service.BookService;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("Main - 'spring-framework-I-h-fundamentals' - Start");
        System.out.println("****************************************");

        // Creates the beans in AppConfig
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
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
        System.out.println("Main - 'spring-framework-I-h-fundamentals' - End");
        System.out.println("*************************************");
    }
}