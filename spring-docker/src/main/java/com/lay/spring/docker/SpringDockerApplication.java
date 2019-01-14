package com.lay.spring.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.lay.spring.docker.filter")
public class SpringDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
    }

}

