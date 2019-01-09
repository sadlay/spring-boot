package com.lay.springboot.springsecurity.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:43 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class BaseController {
    @RequestMapping("/")
    public String index() {
        return "redirect:welcome";
    }


    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Spring Security!";
    }

    @RequestMapping("/csrf/form")
    public String csrfForm() {
        return "csrf_form";
    }

    @PostMapping("/csrf/commit")
    @ResponseBody
    public String commit(HttpServletRequest request) {
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
             username=((UserDetails) principal).getUsername();
        }else {
             username=principal.toString();
        }
        Map map = request.getParameterMap();
        System.out.println(request);
        System.out.println(username);

        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
// 登录名
        System.out.println("Username:"
                + securityContextImpl.getAuthentication().getName());
// 登录密码，未加密的
        System.out.println("Credentials:"
                + securityContextImpl.getAuthentication().getCredentials());
        WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl
                .getAuthentication().getDetails();
// 获得访问地址
        System.out.println("RemoteAddress" + details.getRemoteAddress());
// 获得sessionid
        System.out.println("SessionId" + details.getSessionId());
// 获得当前用户所拥有的权限
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
                .getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            System.out.println("Authority" + grantedAuthority.getAuthority());
        }
        return "success";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "redirect:/csrf/form";
    }
}
