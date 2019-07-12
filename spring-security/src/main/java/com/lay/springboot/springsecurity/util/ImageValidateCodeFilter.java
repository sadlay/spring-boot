package com.lay.springboot.springsecurity.util;

import com.lay.springboot.springsecurity.controller.ImageValidateController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:41 2019/1/11
 * @Modified By:IntelliJ IDEA
 */
public class ImageValidateCodeFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SessionStrategy sessionStrategy= new HttpSessionSessionStrategy();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //当请求路径为/login，且请求为POST请求时，才执行验证。（对应登录页面发送的请求）
        if(StringUtils.equals("/login",request.getRequestURI())
                &&StringUtils.equalsIgnoreCase(request.getMethod(),"POST")){
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
            }
        }
        filterChain.doFilter(request,response);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException,ValidateCodeException {
        //从请求中获取之前存入session的验证码
        ImageCode imageCodeInSession = (ImageCode) sessionStrategy.getAttribute(request, ImageValidateController.SESSION_KEY);
        //获取form表单中用户输入的验证码
        String codeInRequest= ServletRequestUtils.getStringParameter(request.getRequest(),"imageCode");
        if(StringUtils.isBlank(codeInRequest)){
            throw new ValidateCodeException("验证码不能为空");
        }
        if(imageCodeInSession==null){
            throw new ValidateCodeException("验证码不存在");
        }
        if(imageCodeInSession.isExpired()){
            sessionStrategy.removeAttribute(request,ImageValidateController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }
        if(!StringUtils.equals(imageCodeInSession.getCode(),codeInRequest)){
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(request,ImageValidateController.SESSION_KEY);
    }

    class ValidateCodeException extends AuthenticationException {

        public ValidateCodeException(String msg) {
            super(msg);
        }
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }
}
