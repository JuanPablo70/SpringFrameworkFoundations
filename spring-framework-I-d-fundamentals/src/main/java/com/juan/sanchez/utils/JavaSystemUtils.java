package com.juan.sanchez.utils;

public class JavaSystemUtils {

    public static void reportEnvironment() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Report - 'Java System Environment'");
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.println(" JAVA_HOME: " + System.getenv("JAVA_HOME"));
        System.out.println(" JRE_HOME : " + System.getenv("JRE_HOME"));
    }

    public static void reportProperties() {
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Report - 'Java System Properties'");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println(" spring.application.context.version: " +

                System.getProperty("spring.application.context.version"));

        System.out.println(" spring.application.context.report: " +

                System.getProperty("spring.application.context.report"));

        System.out.println(" spring.profiles.default : " +

                System.getProperty("spring.profiles.default"));

        System.out.println(" spring.profiles.active : " +
                System.getProperty("spring.profiles.active"));

        System.out.println(" app.version : " +

                System.getProperty("app.version"));

    }

    private JavaSystemUtils() {
    }

}
