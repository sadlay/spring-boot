package com.lay.spring.session.HttpSessionDemo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:45 2019/1/16
 * @Modified By:IntelliJ IDEA
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("testKey","88888888@qq.com");
        req.getSession().setMaxInactiveInterval(10*1000);
        resp.sendRedirect(req.getContextPath()+"/session");
    }
}
