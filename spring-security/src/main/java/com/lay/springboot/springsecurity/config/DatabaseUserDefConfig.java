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
        configureRememberMe(http);
        http.httpBasic().realmName("my-basic-name");
    }

    //用户认证功能————记住我
    protected void configureRememberMe(HttpSecurity http) throws Exception{
        http
                //访问/admin下的请求需要管理员权限
            .authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                // 启用remember me 功能
            .and().rememberMe().tokenValiditySeconds(86400).key("remember-me-key")
                //启用http batic功能
            .and().httpBasic()
                //通过签名后可以访问任何请求
            .and().authorizeRequests().antMatchers("/**").permitAll()
                //设置登陆页和默认的跳转路径
            .and().formLogin().loginPage("/login/page")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin/welcome1")
                //等处页面和默认跳转路径
                .and().logout().logoutUrl("/logout/page")
                .logoutSuccessUrl("/welcome");
    }

    private void configureBySelect(HttpSecurity http) throws Exception{
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
