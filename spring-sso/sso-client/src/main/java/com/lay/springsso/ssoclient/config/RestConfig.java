package com.lay.springsso.ssoclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:29 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class RestConfig {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
