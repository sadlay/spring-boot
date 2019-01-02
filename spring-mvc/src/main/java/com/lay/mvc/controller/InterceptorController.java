package com.lay.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description: 拦截器控制器
 * @Author: lay
 * @Date: Created in 14:23 2018/11/15
 * @Modified By:IntelliJ IDEA
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @GetMapping("/start")
    public String start(HttpSession session){
        System.out.println("执行处理器逻辑");
        session.setAttribute("sessionValue","hello world");
        return "/welcome";
    }
}
