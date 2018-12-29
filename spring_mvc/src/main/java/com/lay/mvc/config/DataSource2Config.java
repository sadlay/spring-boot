package com.lay.mvc.config;

import com.lay.mvc.entity.Person;
import com.lay.mvc.typehandler.SexTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:25 2018/12/14
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@MapperScan(basePackages = "com.lay.mvc.dao.db2", sqlSessionTemplateRef  = "sqlSessionTemplate2")
public class DataSource2Config {

    @Bean(name="dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        bean.setTypeAliases(new Class[]{Person.class});
        bean.setTypeHandlers(new SexTypeHandler[]{new SexTypeHandler()});
        //bean.setTypeHandlersPackage("com.lay.mvc.typehandler");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml"));
        return bean.getObject();
    }

    @Bean(name="transactionManager2")
    public DataSourceTransactionManager transactionManager2(@Qualifier("dataSource2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
