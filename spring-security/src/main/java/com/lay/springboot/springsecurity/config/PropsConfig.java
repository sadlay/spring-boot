package com.lay.springboot.springsecurity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 12:04 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@Component
@ConfigurationProperties("system.user")
public class PropsConfig {

    public static Map<String,String> password;

    public  void setPassword(Map<String, String> password) {
        PropsConfig.password = password;
    }
}
