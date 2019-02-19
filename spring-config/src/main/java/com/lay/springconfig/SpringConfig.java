package com.lay.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:32 2019/2/19
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class SpringConfig {

    @Autowired
    Environment environment;

    @PostConstruct
    public void init(){
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();
        String username = environment.getProperty("lay.username");
        System.out.println(username);
    }
}
