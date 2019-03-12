package com.sso.client.controller;

import com.sso.client.utils.CookieUtil;
import com.sso.client.utils.EnvVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {

    @Autowired
    EnvVariable envVariable;

    @RequestMapping("/")
    public String home(HttpServletResponse response) {
        response.setHeader("stateCode","-3");
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(HttpServletResponse response) {
        response.setHeader("statusCode","-4");
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, envVariable.getJwtTokenCookieName(),envVariable.getCookieParentDomain());
        return "redirect:/";
    }
}
