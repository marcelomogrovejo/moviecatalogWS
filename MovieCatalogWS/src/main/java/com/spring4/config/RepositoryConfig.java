package com.spring4.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.spring4.repository", entityManagerFactoryRef="emf")
@EnableAutoConfiguration
public class RepositoryConfig {

}
