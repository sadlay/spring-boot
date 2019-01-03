package com.lay.springboot.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 9:28 2019/1/3
 * @Modified By:IntelliJ IDEA
 */
//@Configuration
public class MemoryUserConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编译器
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //使用内存存储
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig
                = auth.inMemoryAuthentication()
                //设置密码编译器
                .passwordEncoder(passwordEncoder);
        //注册用户admin，密码为abc，并赋予USER和ADMIN角色权限
        userConfig.withUser("admin")
                .password("$2a$10$yc1z/VMziUEuMEa9MwjZ3.mt1.APgvIYEmIncGpMkmoiJdN4tXVlq")
                .authorities("ROLE_USER", "ROLE_ADMIN");
        //注册用户myuser，密码为123456，并赋予USER角色权限
        userConfig.withUser("myuser")
                .password("$2a$10$3.PtDezr2cwo2sbV2wtNLefVnXkeHUs48m03YlJNRReQEvfCqK5eO")
                .authorities("ROLE_USER");

    }


    protected void configure1(AuthenticationManagerBuilder auth) throws Exception {
        //密码编译器
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //使用内存存储
        auth.inMemoryAuthentication()
                //设置密码编译器
                .passwordEncoder(passwordEncoder)
                //注册用户admin，密码为abc，并赋予USER和ADMIN的角色权限
                .withUser("admin")
                //可通过passwordEncoder.encode("abc")得到加密后的密码
                .password("$2a$10$yc1z/VMziUEuMEa9MwjZ3.mt1.APgvIYEmIncGpMkmoiJdN4tXVlq")
                .roles("USER", "ADMIN")
                //连接方法and
                .and()
                //注册用户myuser，密码为123456，并赋予USER角色权限
                .withUser("$2a$10$3.PtDezr2cwo2sbV2wtNLefVnXkeHUs48m03YlJNRReQEvfCqK5eO")
                .password("123")
                .roles("USER");
    }

}
