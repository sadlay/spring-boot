package com.lay.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 12:47 2019/4/8
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class TestController {

    @RequestMapping("/test/ip")
    public String testIp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(" getRemoteHost: "+request.getRemoteHost());
        System.out.println(" getRemoteAddr: "+request.getRemoteAddr());
        System.out.println(" getLocalAddr: "+request.getLocalAddr());
        System.out.println(" getRequestURI: "+request.getRequestURI());
        System.out.println(" getRequestURL: "+request.getRequestURL());
        System.out.println(" getContextPath: "+request.getContextPath());
        System.out.println(" getServletPath: "+request.getServletPath());

        System.out.println(" getRemotePort: "+request.getRemotePort());
        System.out.println(" getServerPort: "+request.getServerPort());
        System.out.println(" getLocalPort: "+request.getLocalPort());
        System.out.println(" getServerName: "+request.getServerName());
        System.out.println(" getScheme: "+request.getScheme());
        PrintWriter writer = response.getWriter();
        writer.write("jjjj");
        writer.flush();
        writer.close();
        return null;
    }

}
