package com.lay.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:13 2019/2/19
 * @Modified By:IntelliJ IDEA
 */
@SpringBootApplication
public class SpringConfigApplication {


    public static void main(String[] args){
        SpringApplication.run(SpringConfigApplication.class, args);
    }

}
