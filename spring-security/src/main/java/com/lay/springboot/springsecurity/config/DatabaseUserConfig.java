package com.lay.springboot.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:10 2019/1/3
 * @Modified By:IntelliJ IDEA
 */
//@Configuration
public class DatabaseUserConfig extends WebSecurityConfigurerAdapter {
    //注入配置的阴匙
    @Value("${system.user.password.secret}")
    private String secret;
    //注入数据源
    @Autowired
    private DataSource dataSource;
    //使用用户名名称查询密码
    String pwdQuery="select user_name,pwd,available " +
            "from t_user where user_name=? ";
    //使用用户名称查询角色信息
    String roleQuery="select u.user_name,r.role_name " +
            "from t_user u, t_user_role ur,t_role r " +
            "where u.id=ur.user_id and r.id=ur.role_id " +
            "and u.user_name=? ";
    /**
     *
     * @Description: 覆盖WebSecurityConfigurerAdapter用户详情方法
     * @param: [auth] 用户签名管理器构造器
     * @return: void
     * @auther: lay
     * @date: 10:22 2019/1/3
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编译器
        PasswordEncoder passwordEncoder=new Pbkdf2PasswordEncoder(secret);
        auth.jdbcAuthentication()
                //密码加密
                .passwordEncoder(passwordEncoder)
                //数据源
                .dataSource(dataSource)
                //查询用户，自动判断密码是否一致
                .usersByUsernameQuery(pwdQuery)
                //赋予权限
                .authoritiesByUsernameQuery(roleQuery);
    }

    /**
     *
     * @Description: 覆盖WebSecurityConfigurerAdapter用户详情方法
     * @param: [auth] 用户签名管理器构造器
     * @return: void
     * @auther: lay
     * @date: 10:22 2019/1/3
     */
    protected void configure1(AuthenticationManagerBuilder auth) throws Exception {
        //密码编译器
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        auth.jdbcAuthentication()
                //密码加密
                .passwordEncoder(passwordEncoder)
                //数据源
                .dataSource(dataSource)
                //查询用户，自动判断密码是否一致
                .usersByUsernameQuery(pwdQuery)
                //赋予权限
                .authoritiesByUsernameQuery(roleQuery);
    }

}
