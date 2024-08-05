package com.juan.sanchez.config.system;

import com.juan.sanchez.service.SystemEnvironmentReportService;
import com.juan.sanchez.service.SystemPropertiesReportService;
import com.juan.sanchez.service.impl.SystemEnvironmentReportServiceImpl;
import com.juan.sanchez.service.impl.SystemPropertiesReportServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AppSystemConfig {

    @Value("#{systemProperties['spring.application.context.version']}")
    private String springApplicationContextVersion;

    @Value("#{systemProperties['spring.application.context.report']}")
    private Boolean springApplicationContextReport;

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHome;

    /**
     * <pre class="code">
     * @Value("#{systemProperties['app.version']}")
     * @Value("#{systemProperties['app.version'] ?: ''}")
     * @Value("#{systemProperties['app.version'] ?: 'Not Defined'}")
     * </pre>
     *
     * @param springProfilesDefault the array of spring default profiles
     * @param springProfilesActive the array of spring active profiles
     * @return the reporting object for System Properties
     */
    @Bean
    SystemPropertiesReportService systemPropertiesReportService(
            @Value("#{systemProperties['spring.profiles.default']}") String[] springProfilesDefault,
            @Value("#{systemProperties['spring.profiles.active']}") String[] springProfilesActive,
            @Value("#{systemProperties['app.version'] ?: 'Not Defined'}") String appVersion) {
        return new SystemPropertiesReportServiceImpl(
                springApplicationContextVersion,
                springApplicationContextReport,
                springProfilesDefault, springProfilesActive,
                appVersion);
    }

    /**
     * <pre class="code">
     * @Value("#{systemEnvironment['JRE_HOME']}")
     * @Value("#{systemEnvironment['JRE_HOME'] ?: ''}")
     * @Value("#{systemEnvironment['JRE_HOME'] ?: 'Not Defined'}")
     * </pre>
     *
     * @param jreHome the location of JRE_HOME
     * @return the reporting object for System Environment
     */
    @Bean
    SystemEnvironmentReportService systemEnvironmentReportService(
            @Value("#{systemEnvironment['JRE_HOME'] ?: ''}") String jreHome) {
        return new SystemEnvironmentReportServiceImpl(javaHome, jreHome);
    }

}
