package com.juan.sanchez.app.config;

import com.juan.sanchez.config.environment.AppEnvironmentConfig;
import com.juan.sanchez.config.infrastructure.InfrastructureConfig;
import com.juan.sanchez.config.logging.LoggingConfig;
import com.juan.sanchez.config.name.AppNameConfig;
import com.juan.sanchez.config.repository.RepositoryP1Config;
import com.juan.sanchez.config.repository.RepositoryP2Config;
import com.juan.sanchez.config.service.ServiceP1Config;
import com.juan.sanchez.config.service.ServiceP2Config;
import com.juan.sanchez.config.system.AppSystemConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppSystemConfig.class, AppEnvironmentConfig.class, AppNameConfig.class,
        InfrastructureConfig.class, LoggingConfig.class,
        RepositoryP1Config.class, RepositoryP2Config.class,
        ServiceP1Config.class, ServiceP2Config.class})
public class AppImportConfig {

    AppImportConfig(){
        System.out.println("");
        System.out.println("********************************");
        System.out.println("*** AppImportConfig - Created ***");
        System.out.println("********************************");
    }

}
