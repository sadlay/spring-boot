package com.lay.springsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:23 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@SpringBootApplication
@ServletComponentScan
public class SpringSsoApplication {

    public static void main(String[] args){
        SpringApplication.run(SpringSsoApplication.class,args);
    }
}
