package com.juan.sanchez.config.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("log")
public class LoggingConfig {

    @Profile("debug")
    @Bean(name="appLogging")
    String appLoggingDebug() {
        return "Logging for Debug";
    }

    @Profile("info")
    @Bean(name="appLogging")
    String appLoggingInfo() {
        return "Logging for Info";
    }

}
