package com.juan.sanchez.main;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.AuthorService;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("Main - 'spring-framework-jdbc-a' - Start");
        System.out.println("****************************************");

        // Creates the beans in AppConfig
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("");
        System.out.println("-------------------");
        System.out.println(" BookService ");
        System.out.println("-------------------");
        System.out.println("");

        // Gets the bean that returns BookService
        BookService bookService = ctx.getBean(BookService.class);

        System.out.println("");
        System.out.println("--------------------");
        System.out.println("Report - 'findById'");
        System.out.println("--------------------");
        System.out.println("");
        bookService.report(bookService.findById(1));
        bookService.report(bookService.findById(5));
        bookService.report(bookService.findById(7));

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

        System.out.println("");
        System.out.println("-------------------");
        System.out.println(" AuthorService ");
        System.out.println("-------------------");
        System.out.println("");

        AuthorService authorService = ctx.getBean(AuthorService.class);

        System.out.println("");
        System.out.println("--------------------");
        System.out.println("Report - 'findById'");
        System.out.println("--------------------");
        System.out.println("");
        authorService.report(authorService.findById(1));
        authorService.report(authorService.findById(5));
        authorService.report(authorService.findById(7));

        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Report - 'findByIdWithBooks'");
        System.out.println("-----------------------------------");
        System.out.println("");
        authorService.reportWithBooks(authorService.findByIdWithBooks(4));

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("Report - 'findAll'");
        System.out.println("-------------------");
        System.out.println("");
        authorService.report(authorService.findAll());

        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Report - 'findAllWithBooks'");
        System.out.println("-----------------------------------");
        System.out.println("");
        authorService.reportWithBooks(authorService.findAllWithBooks());

        System.out.println("");
        System.out.println("----------------------");
        System.out.println("Report - 'count'");
        System.out.println("----------------------");
        System.out.println("");
        authorService.report(authorService.count());

        Optional.ofNullable(System.getProperty("spring.application.context.report"))
                        .ifPresent(t -> {
                            if (t.equals("true")) {
                                SpringFrameworkUtils.profilesAndBeansDefinitionsReport(ctx);
                            }
                        });
        ctx.close();

        System.out.println("");
        System.out.println("*************************************");
        System.out.println("Main - 'spring-framework-jdbc-a' - End");
        System.out.println("*************************************");
    }
}