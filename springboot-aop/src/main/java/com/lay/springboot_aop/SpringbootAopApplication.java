package com.lay.springboot_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lay.springboot_aop.aspect.MyAspect;

@SpringBootApplication(scanBasePackages= {"com.lay.springboot_aop.aspect"})
public class SpringbootAopApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopApplication.class, args);
	}
	@Bean(name="myAspect")
	public MyAspect initMyAspect() {
	    return new MyAspect();
	}
}
