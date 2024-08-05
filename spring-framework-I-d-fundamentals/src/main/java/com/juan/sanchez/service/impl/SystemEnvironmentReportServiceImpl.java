package com.juan.sanchez.service.impl;

import com.juan.sanchez.service.SystemEnvironmentReportService;

public class SystemEnvironmentReportServiceImpl implements SystemEnvironmentReportService {

    private final String javaHome;

    private final String jreHome;

    public SystemEnvironmentReportServiceImpl(String javaHome, String jreHome) {
        this.javaHome = javaHome;
        this.jreHome = jreHome;
    }

    @Override
    public void report() {
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("Report - 'Spring SpEL System Environment'");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println(" JAVA_HOME: " + javaHome);
        System.out.println(" JRE_HOME : " + jreHome);
    }

}
