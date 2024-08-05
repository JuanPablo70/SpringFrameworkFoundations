package com.juan.sanchez.config.name;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//Custom profile, not the default one
@Profile("default")
public class AppNameConfig {

    @Bean
    String appName() {
        return "Spring Framework App";
    }

}
