package com.lay.spring.docker.filter;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:53 2019/1/12
 * @Modified By:IntelliJ IDEA
 */
@Component
//@WebFilter(urlPatterns = "/*",filterName = "my-filter")
public class MyFilter2 extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("do filter2");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
