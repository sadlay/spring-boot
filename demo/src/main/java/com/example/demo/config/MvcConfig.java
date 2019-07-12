package com.example.demo.config;

import com.example.demo.interceptor.MyInterceptor;
import com.example.demo.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 1:09 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*").order(2);
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/*").order(1);
    }
}
