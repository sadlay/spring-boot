package com.lay.springboot.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:33 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class DatabaseUserDefConfig extends WebSecurityConfigurerAdapter {
    //注入配置的阴匙
    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * @Description: 覆盖WebSecurityConfigurerAdapter用户详情方法
     * @param: [auth] 用户签名管理器构造器
     * @return: void
     * @auther: lay
     * @date: 10:22 2019/1/3
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编译器
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(secret);
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //限定签名后的权限
        http.
                //requiresChannel().antMatchers("/admin/**").requiresSecure()
                /*##########第一段##########*/
                        authorizeRequests()
                //限定
                .antMatchers("/user/welcome", "/user/details").hasAnyRole("USER", "ADMIN")
                //
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                //
                .anyRequest().permitAll()

                /*##########第二段##########*/
                /* and代表连接词*/
                //对于没有配置权限的其他请求允许匿名访问
                .and().anonymous()

                /*##########第三段##########*/
                /* 使用spring security默认的登陆页面*/
                .and().formLogin()
                .and().rememberMe()
                //启动http基础验证
                .and().httpBasic();

    }

}
