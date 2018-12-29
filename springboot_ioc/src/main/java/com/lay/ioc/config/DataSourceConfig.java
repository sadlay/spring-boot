package com.lay.ioc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("dev")
    public DataSource getDevDataSource() {
        Properties prop = new Properties();
        prop.setProperty("driver", "com.mysql.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/dev_spring_boot");
        prop.setProperty("username", "root");
        prop.setProperty("password", "123456");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("成功加载dev数据源");
        return dataSource;
    }
    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("test")
    public DataSource getTestDataSource() {
        Properties prop = new Properties();
        prop.setProperty("driver", "com.mysql.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/dev_spring_boot");
        prop.setProperty("username", "root");
        prop.setProperty("password", "654321");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("成功加载test数据源");
        return dataSource;
    }
}
