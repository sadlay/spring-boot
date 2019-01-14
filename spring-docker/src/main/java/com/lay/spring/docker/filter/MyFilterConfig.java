package com.lay.spring.docker.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.AbstractFilterRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:44 2019/1/12
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setName("my-filter");
        filterRegistrationBean.addUrlPatterns("/home");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.setName("my-filter2");
        filterRegistrationBean.addUrlPatterns("/home");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
