package com.lay.springboot.beetl.config;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.SimpleCacheInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:beetlSql配置类
 * @Author: lay
 * @Date: Created in 17:25 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class BeetlConfig {

    //环境变量注入
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
                                                       @Qualifier("slavesSource") DataSource slaveSource) {
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        //主数据库
        source.setMasterSource(datasource);
        //从数据库
        source.setSlaves(new DataSource[]{slaveSource});
        factory.setCs(source);
        //数据库类型
        factory.setDbStyle(new MySqlStyle());
        //debug模式 开发时使用
        factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        //命名转换方式
        factory.setNc(new UnderlinedNameConversion());
        factory.setSqlLoader(new ClasspathLoader("/sql"));
        return factory;
    }

    /**
     *
     * @Description: SQLManager配置2
     * @param:
     * @param datasource
     * @param slaveSource
     * @return: org.beetl.sql.core.SQLManager
     * @auther: lay
     * @date: 15:42 2019/1/21
     */
    //@Bean
    public SQLManager sqlManager(@Qualifier("masterSource") DataSource datasource,
                                 @Qualifier("slavesSource") DataSource slaveSource){
        ConnectionSource source= ConnectionSourceHelper.getMasterSlave(datasource,new DataSource[]{slaveSource});
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        //List<String> lcs=new ArrayList<>();
        //lcs.add("tUser");
        //缓存
        //SimpleCacheInterceptor cache=new SimpleCacheInterceptor(lcs);
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        return sqlManager;
    }

    //开启事务管理
    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("masterSource") DataSource datasource) {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager();
        dsm.setDataSource(datasource);
        return dsm;
    }

    //主库
    //@Bean(name = "masterSource")
    public DataSource masterSouirce(Environment env) throws SQLException {
        return DataSourceBuilder.
                create()
                .url("jdbc:mysql://192.168.3.253:3306/spring_security?useUnicode=true&characterEncoding=UTF-8&useSSL=false")
                .username("developer")
                .password("1q@W3e$R")
                .build();
    }

    //主库
    //@Bean(name = "slavesSource")
    public DataSource slavesDataSource(Environment env) throws SQLException {
        return DataSourceBuilder.
                create()
                .url("jdbc:mysql://192.168.3.253:3306/spring_security?useUnicode=true&characterEncoding=UTF-8&useSSL=false")
                .username("developer")
                .password("1q@W3e$R")
                .build();
    }


}
