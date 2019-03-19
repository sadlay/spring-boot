package com.lay.log.core.config;

import com.lay.log.core.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 12:31 2019/3/19
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class LogConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        Filter logFilter = new LogFilter();
        registrationBean.setFilter(logFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
