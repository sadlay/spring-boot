package com.lay.mvc.config;

import com.lay.mvc.entity.Person;
import com.lay.mvc.typehandler.SexTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:25 2018/12/14
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@MapperScan(basePackages = "com.lay.mvc.dao.db1", sqlSessionTemplateRef  = "sqlSessionTemplate1")
public class DataSource1Config {

    @Bean(name="dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        bean.setTypeAliases(new Class[]{Person.class});
        bean.setTypeHandlersPackage("com.lay.mvc.typehandler");


        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml"));
        return bean.getObject();
    }

    @Bean(name="transactionManager1")
    @Primary
    public DataSourceTransactionManager transactionManager1(@Qualifier("dataSource1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
