package com.lay.springboot.beetl.config;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:25 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class BeetlConfig  {
    @Autowired
    Environment environment;

    //配置包扫描
    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("com.lay.springboot.beetl.*");
        conf.setDaoSuffix("Dao");
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return conf;
    }


    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean sqlManagerFactoryBean(@Qualifier("masterSource") DataSource datasource,
                                                          @Qualifier("slavesSource") DataSource slavesSouirce) {
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        //主数据库
        source.setMasterSource(datasource);
        //从数据库
        source.setSlaves(new DataSource[] {slavesSouirce});
        factory.setCs(source);
        factory.setDbStyle(new MySqlStyle());
        factory.setInterceptors(new Interceptor[] {new DebugInterceptor()});
        factory.setNc(new UnderlinedNameConversion());
        factory.setSqlLoader(new ClasspathLoader("/sql"));
        return factory;
    }

    //主库
    @Bean(name = "masterSource")
    public DataSource masterSouirce(Environment env) throws SQLException {
        return  DataSourceBuilder.
                create()
                .url("jdbc:mysql://192.168.3.253:3306/spring_security?useUnicode=true&characterEncoding=UTF-8&useSSL=false")
                .username("developer")
                .password("1q@W3e$R")
                .build();
    }
    //主库
    @Bean(name = "slavesSource")
    public DataSource slavesDataSource(Environment env) throws SQLException {
        return  DataSourceBuilder.
                create()
                .url("jdbc:mysql://192.168.3.253:3306/spring_security?useUnicode=true&characterEncoding=UTF-8&useSSL=false")
                .username("developer")
                .password("1q@W3e$R")
                .build();
    }
    @Bean(name="txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("masterSource") DataSource datasource) {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager();
        dsm.setDataSource(datasource);
        return dsm;
    }


}
