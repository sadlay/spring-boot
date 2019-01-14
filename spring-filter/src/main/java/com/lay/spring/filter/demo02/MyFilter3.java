package com.lay.spring.filter.demo02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:49 2019/1/14
 * @Modified By:IntelliJ IDEA
 */
@WebFilter(urlPatterns = "/*",filterName = "my-filter3",displayName = "my-filter3")
public class MyFilter3 implements Filter {
    private static final Logger log= LoggerFactory.getLogger(MyFilter3.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        log.info("MyFilter3过滤器，url：{}",request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
