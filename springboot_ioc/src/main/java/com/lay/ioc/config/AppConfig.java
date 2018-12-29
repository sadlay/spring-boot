package com.lay.ioc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ComponentScan 标明会进行扫描
 * @author Lay
 */
//@SpringBootApplication(scanBasePackages="com.lay.ioc.*")
@PropertySource(value= {"classpath:test1.properties"},ignoreResourceNotFound=true)
@ComponentScan(basePackages= {"com.lay.ioc.*"},lazyInit=true)
@EnableAutoConfiguration
// @ComponentScan(excludeFilters= {@Filter(classes= {Service.class})})
// 或 @ComponentScan(basePackages= {"com.lay.ioc.pojo"})
// 或 @ComponentScan(basePackageClasses= {User.class})
@Configuration
public class AppConfig {

	@Bean(name = "dataSource", destroyMethod = "close")
	@Conditional(value = DataBaseConditional.class)
	public DataSource getDataSource(@Value("${test1.driverName}") String driver, @Value("${test1.url}") String url,
			@Value("${test1.username}") String username, @Value("${test1.password}") String password) {
		Properties prop = new Properties();
		prop.setProperty("driver", driver);
		prop.setProperty("url", url);
		prop.setProperty("username", username);
		prop.setProperty("password", password);
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
