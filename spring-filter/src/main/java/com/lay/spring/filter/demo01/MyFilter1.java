package com.lay.spring.filter.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:00 2019/1/14
 * @Modified By:IntelliJ IDEA
 */
@Component
public class MyFilter1 implements Filter {
    private static final Logger log= LoggerFactory.getLogger(MyFilter1.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        log.info("MyFilter1过滤器，url：{}",request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
