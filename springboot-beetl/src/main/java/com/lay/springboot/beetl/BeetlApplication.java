package com.lay.springboot.beetl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class BeetlApplication {


    public static void main(String[] args) {
        SpringApplication.run(BeetlApplication.class, args);
    }

}

