package com.juan.sanchez.main;

import com.juan.sanchez.factory.SpringFrameworkFactory;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.SystemEnvironmentReportService;
import com.juan.sanchez.service.SystemPropertiesReportService;
import com.juan.sanchez.utils.JavaSystemUtils;
import com.juan.sanchez.utils.SpringFrameworkUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("Main - 'spring-framework-I-d-fundamentals' - Start");
        System.out.println("****************************************");

        ConfigurableApplicationContext ctx =
                (ConfigurableApplicationContext) SpringFrameworkFactory.createApplicationContext();

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Recovering Beans - 'Spring ApplicationContext'");
        System.out.println("-----------------------------------------------");
        System.out.println("");

        try {
            System.out.println(" beanName: 'appName'");
            String appName = (String) ctx.getBean("appName");
            System.out.println("\t " + appName);
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        try {
            System.out.println(" beanName: 'appEnv'");
            String appEnv = ctx.getBean("appEnv", String.class);
            System.out.println("\t " + appEnv);
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        try {
            System.out.println(" beanName: 'appLogging'");
            String appLogging = ctx.getBean("appLogging", String.class);
            System.out.println("\t " + appLogging);
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        System.out.println(" beanName: 'systemEnvironmentReportService'");
        SystemEnvironmentReportService systemEnvironmentReportService =
                ctx.getBean(SystemEnvironmentReportService.class);
        System.out.println(" beanName: 'systemPropertiesReportService'");
        SystemPropertiesReportService systemPropertiesReportService =
                ctx.getBean(SystemPropertiesReportService.class);

        BookService bookService = null;

        try {
            System.out.println(" beanName: 'bookService' - I");
            bookService = (BookService) ctx.getBean("bookService");
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        try {
            System.out.println(" beanName: 'bookService' - II");
            bookService = ctx.getBean("bookService", BookService.class);
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        try {
            System.out.println(" beanName: 'bookService' - III");
            bookService = ctx.getBean(BookService.class);
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("\t Exception message: " + ex.getMessage());
        }

        if(bookService != null) {
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
            System.out.println("-----------------");
            System.out.println("Report - 'count'");
            System.out.println("-----------------");
            System.out.println("");
            bookService.report(bookService.count());
        }

        systemEnvironmentReportService.report();
        systemPropertiesReportService.report();

        JavaSystemUtils.reportEnvironment();
        JavaSystemUtils.reportProperties();
        Optional.ofNullable(System.getProperty("spring.application.context.report"))

                .ifPresent(t -> {
                    if(t.equals("true")) {
                        SpringFrameworkUtils.reportProfilesAndBeansDefinitions(ctx);
                    }
                });
        ctx.close();

        System.out.println("");
        System.out.println("*************************************");
        System.out.println("Main - 'spring-framework-I-d-fundamentals' - End");
        System.out.println("*************************************");
    }
}