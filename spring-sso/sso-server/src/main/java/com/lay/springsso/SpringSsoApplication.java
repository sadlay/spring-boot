package com.lay.springsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:08 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@SpringBootApplication
public class SpringSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSsoApplication.class, args);
    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
