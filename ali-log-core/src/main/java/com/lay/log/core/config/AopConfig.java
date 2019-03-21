package com.lay.log.core.config;

import com.lay.log.core.aop.ControllerAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:31 2019/3/20
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public ControllerAop controllerAop(){
        return new ControllerAop();
    }
}
