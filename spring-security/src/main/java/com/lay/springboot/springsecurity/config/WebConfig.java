package com.lay.springboot.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:51 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**使用新增映射关系，省去用传统的映射器取控制
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //使得/login/page映射为login.html
        registry.addViewController("/login/page").setViewName("login");
        //使得/logout/page映射为logout_welcome.html
        registry.addViewController("/logout/page").setViewName("logout_welcome");
        //使得/logout映射为logout.html
        registry.addViewController("/logout").setViewName("logout");
    }
}
