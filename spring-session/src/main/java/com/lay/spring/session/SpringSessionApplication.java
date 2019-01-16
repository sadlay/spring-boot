package com.lay.spring.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.web.http.SessionRepositoryFilter;

import javax.servlet.ServletContainerInitializer;

@SpringBootApplication
@ServletComponentScan
public class SpringSessionApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

}

