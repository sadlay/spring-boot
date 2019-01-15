package com.lay.utils.util.controller;

import com.lay.utils.util.web.CookieUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:59 2019/1/15
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class TestController {

    @GetMapping("/cookie")
    public String testCookie(HttpServletRequest request, HttpServletResponse response){
        CookieUtils.addCookie(response,"test-cookie","cookie-value",10);
        return "cookie";
    }

    @GetMapping("/getCookie")
    public String getCookie(HttpServletRequest request){
        String cookieValue = CookieUtils.getCookieValueByName(request, "test-cookie");
        return cookieValue;
    }
}
