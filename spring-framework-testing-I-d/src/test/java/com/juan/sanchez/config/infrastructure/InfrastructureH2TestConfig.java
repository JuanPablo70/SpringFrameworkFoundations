package com.juan.sanchez.config.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
class InfrastructureH2TestConfig {

    @Bean
    @Profile("dev")
    DataSource dataSourceH2() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.H2)
                .setName("test-dev-springlatam-db")
                .addScript("classpath:/com/juan/sanchez/h2/v1/schema.sql")
                .addScript("classpath:/com/juan/sanchez/h2/v1/data.sql")
                .build();
        return database;
    }

}
