package com.example.demo.filter;

import com.example.demo.controller.User;
import com.example.demo.core.UserHolder;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:49 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
@Component
public class MyFilter extends HttpFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("before MyFilter");
        String token = request.getParameter("token");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        User userFromToken = tokenService.getUserFromToken(token);
        UserHolder.set(userFromToken);
        //User user = new User();
//        ServletRequestWrapper servletRequestWrapper = new ServletRequestWrapper(request, user);

        try {
            chain.doFilter(request, response);
        } finally {
            UserHolder.remove();
        }


        System.out.println("after MyFilter");
    }

/*    private class ServletRequestWrapper extends HttpServletRequestWrapper {

        private Principal principal;

        public ServletRequestWrapper(HttpServletRequest request, Principal principal) {
            super(request);
            this.principal = principal;
        }

        @Override
        public Principal getUserPrincipal() {
            return principal;
        }
    }*/
}
