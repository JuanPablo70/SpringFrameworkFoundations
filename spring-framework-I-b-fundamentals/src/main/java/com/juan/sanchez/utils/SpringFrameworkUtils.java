package com.juan.sanchez.utils;

import org.springframework.context.ApplicationContext;

public class SpringFrameworkUtils {

    public static void beansDefinitionsReport(ApplicationContext ctx) {
        System.out.println("");
        System.out.println("-------------------------------------");
        System.out.println("Report - 'Spring ApplicationContext'");
        System.out.println("-------------------------------------");
        System.out.println("");
        System.out.println("Number of Beans: " + ctx.getBeanDefinitionCount());
        System.out.println("Definitions of Beans: ");
        for(String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(" " + beanName);
        }
    }

    private SpringFrameworkUtils() {

    }

}
