package com.lay.spring.filter.demo03;


import com.lay.spring.filter.demo02.MyFilter4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
@WebFilter(urlPatterns = "/*",filterName = "my-filter5")
public class MyFilter5 extends OncePerRequestFilter{
    private static final Logger log= LoggerFactory.getLogger(MyFilter5.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("MyFilter5 OncePerRequestFilter 过滤器，url：{}",httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
