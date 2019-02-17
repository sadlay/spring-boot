package com.lay.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.lay.dao.MyBatisPersonDao;

import javax.sql.DataSource;

//@Configuration

public class MybatisConfig {
    //这里的SqlSessionFactory是spring boot自动为我们生成的。
    @Autowired
    SqlSessionFactory sqlSessionFactory = null;
    
    @Bean
    public MapperFactoryBean<MyBatisPersonDao> initMyBatisUserDao() {
        MapperFactoryBean<MyBatisPersonDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(MyBatisPersonDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfig() {
        //定义扫描器实例
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //加载SqlSessionFactory，spring boot会自动生产SqlSessionFactory实例
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //定义扫描的包
        mapperScannerConfigurer.setBasePackage("com.lay.dao");
        //限定被标注@Mapper的接口才被扫描
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        return mapperScannerConfigurer;
    }
}
