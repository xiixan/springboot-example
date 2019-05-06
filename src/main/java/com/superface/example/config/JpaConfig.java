package com.superface.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JpaConfig
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.superface.example.repositories"})
public class JpaConfig {

    
}