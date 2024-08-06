package com.juan.sanchez.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.juan.sanchez.config",
                             "com.juan.sanchez.repository",
                             "com.juan.sanchez.service"})
public class AppConfig {

}
