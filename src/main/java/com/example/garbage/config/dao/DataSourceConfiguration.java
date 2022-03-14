package com.example.garbage.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;


/**
 * JDBC SETTING
 */
@Configuration
@MapperScan("com.example.garbage.main.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;


    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //Set driver
        dataSource.setDriverClass(jdbcDriver);
        //set url
        dataSource.setJdbcUrl(jdbcUrl);
        //set user
        dataSource.setUser(jdbcUser);
        //set password
        dataSource.setPassword(jdbcPassword);
        //set AutoCommit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}