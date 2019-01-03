package com.lay.springboot.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

    //注入配置的阴匙
    @Value("${system.user.password.secret}")
    private String secret;

    @Test
    public void contextLoads() {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password=passwordEncoder.encode("123456");
        System.out.println(password);
    }
    @Test
    public void password() {
        PasswordEncoder passwordEncoder=new Pbkdf2PasswordEncoder(secret);
        String password=passwordEncoder.encode("lay1314");
        System.out.println(password);
    }


}

