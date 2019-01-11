package com.lay.springboot.springsecurity.config;

import com.alibaba.fastjson.JSONObject;
import com.lay.springboot.springsecurity.util.ImageValidateCodeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:33 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class DatabaseUserDefConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(DatabaseUserDefConfig.class);
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
    protected void configureRememberMe(HttpSecurity http) throws Exception {
        //自定义失败处理
        AuthenticationFailureHandler authenticationFailureHandler = (request, response, authentication) -> {
            log.info("登陆失败");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=utf-8");
            //将java对象转成json字符串写入response，Authtication参数中包含我们的认证信息
            response.getWriter().write(JSONObject.toJSONString(authentication));
        };

        ImageValidateCodeFilter validateCodeFilter = new ImageValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        http
                //在进行用户密码校验前过滤
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
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
                //表单form action
                .loginProcessingUrl("/login")
                //默认成功主页
                //.defaultSuccessUrl("/admin/welcome1")
                //自定义认证成功处理
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    log.info("登陆成功");
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    //将java对象转成json字符串写入response，Authtication参数中包含我们的认证信息
                    httpServletResponse.getWriter().write(JSONObject.toJSONString(authentication));
                })
                .failureHandler(authenticationFailureHandler)
                //等处页面和默认跳转路径
                .and().logout().logoutUrl("/logout/page")
                .logoutSuccessUrl("/logout/page");
    }

    private void configureBySelect(HttpSecurity http) throws Exception {
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
