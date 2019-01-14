package com.lay.spring.docker.filter;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:53 2019/1/12
 * @Modified By:IntelliJ IDEA
 */
//@Component
@WebFilter(urlPatterns = "/*",filterName = "my-filter")
public class MyFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("do filter");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
