package com.springbootcourse.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class dbConfiguration {

    private String driverClassName;
    private String url;

    @Profile("dev")
    @Bean
    public String testDataBaseConfiguration(){
        System.out.println("DB connection for DEV-H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDataBaseConfiguration(){
        System.out.println("DB connection for PROD-MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Production instance";
    }

}
