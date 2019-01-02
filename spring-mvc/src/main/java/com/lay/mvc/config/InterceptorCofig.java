package com.lay.mvc.config;

import com.lay.mvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:拦截器配置
 * @Author: lay
 * @Date: Created in 14:18 2018/11/15
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class InterceptorCofig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器到Spring MVC机制，然后它会返回一个拦截器注册
        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
        //指定拦截匹配模式，限制拦截器拦截请求
        ir.addPathPatterns("/interceptor/*");
    }
}
