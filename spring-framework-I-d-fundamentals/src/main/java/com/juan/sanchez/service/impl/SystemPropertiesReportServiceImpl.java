package com.juan.sanchez.service.impl;

import com.juan.sanchez.service.SystemPropertiesReportService;

import java.util.Arrays;
import java.util.List;

public class SystemPropertiesReportServiceImpl implements SystemPropertiesReportService {

    private final String springApplicationContextVersion;

    private final Boolean springApplicationContextReport;

    private final String[] springProfilesDefault;

    private final String[] springProfilesActive;

    private final String appVersion;

    public SystemPropertiesReportServiceImpl(
            String springApplicationContextVersion,
            Boolean springApplicationContextReport,
            String[] springProfilesDefault, String[] springProfilesActive,
            String appVersion) {
        this.springApplicationContextVersion = springApplicationContextVersion;
        this.springApplicationContextReport = springApplicationContextReport;
        this.springProfilesDefault = springProfilesDefault;
        this.springProfilesActive = springProfilesActive;
        this.appVersion = appVersion;
    }

    @Override
    public void report() {
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("Report - 'Spring SpEL System Properties'");
        System.out.println("-----------------------------------------");
        System.out.println("");
        System.out.println(" spring.application.context.version: " + springApplicationContextVersion);
        System.out.println(" spring.application.context.report: " + springApplicationContextReport);
        System.out.println(" spring.profiles.default : " + arrayToList(springProfilesDefault));
        System.out.println(" spring.profiles.active : " + arrayToList(springProfilesActive));
        System.out.println(" appVersion : " + appVersion);
    }

    private List<String> arrayToList(String[] profiles) {
        if(profiles != null) {
            return Arrays.asList(profiles);
        }
        else {
            return null;
        }
    }

}
