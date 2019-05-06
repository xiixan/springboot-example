package com.superface.example.datasource;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DataSourceConfig
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "mysqlOneDataSource")
    @ConfigurationProperties("spring.datasource.druid.mysqlone")
    public DataSource mysqlOneDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTwoDataSource")
    @ConfigurationProperties("spring.datasource.druid.mysqltwo")
    public DataSource mysqlTwoDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mysqlOneJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
	        @Qualifier("mysqlOneDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "mysqlTwoJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(
	        @Qualifier("mysqlTwoDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
    
}