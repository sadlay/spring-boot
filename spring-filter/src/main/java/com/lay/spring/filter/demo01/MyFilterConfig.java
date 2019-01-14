package com.lay.spring.filter.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @Description: filter过滤器注册，如没有FilterRegistrationBean进行注册，则默认全部路径
 * @Author: lay
 * @Date: Created in 10:06 2019/1/14
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@ServletComponentScan(basePackages = "com.lay.spring.filter.demo01")
public class MyFilterConfig {
    /**
     *
     * @Description: 采用spring注入的方式，myFilter1添加@Component注解
     * @param:
     * @param myFilter1
     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
     * @auther: lay
     * @date: 11:04 2019/1/14
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(@Autowired Filter myFilter1){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter1);//注册过滤器
        filterRegistrationBean.setOrder(0);//设置过滤器顺序
        filterRegistrationBean.addUrlPatterns("/filter/*");//匹配路径/filter/*
        return filterRegistrationBean;
    }


    /**
     *
     * @Description: 采用new方式进行注册
     * @param:
     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
     * @auther: lay
     * @date: 11:05 2019/1/14
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());//注册过滤器
        filterRegistrationBean.setOrder(1);//设置过滤器顺序
        filterRegistrationBean.addUrlPatterns("/*");//匹配路径，全部
        return filterRegistrationBean;
    }
}
