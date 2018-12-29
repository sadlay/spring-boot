package com.lay;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages = "com.lay.dao")
//定义实体Bean扫描包路径
//@EntityScan(basePackages = "com.lay.pojo")

@MapperScan(basePackages = "com.lay", annotationClass = Mapper.class)
public class SpringbootDatabaseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatabaseApplication.class, args);
    }
}
