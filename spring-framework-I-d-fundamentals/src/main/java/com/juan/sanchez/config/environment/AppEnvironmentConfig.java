package com.juan.sanchez.config.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppEnvironmentConfig {

    @Profile("prod")
    @Bean(name="appEnv")
    String appEnvProd() {
        return "Environment for Production";
    }

    @Profile("dev")
    @Bean(name="appEnv")
    String appEnvDev() {
        return "Environment for Developing";
    }

}
