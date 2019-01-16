package com.lay.spring.session.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:56 2019/1/15
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class CookieController {


    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @PostConstruct
    public void test(){
        System.out.println("ssss");
    }

    private static final Logger log= LoggerFactory.getLogger(CookieController.class);
    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session){
        //去除session中的browser
        Object sessionBrowser= session.getAttribute("browser");
        if(sessionBrowser==null){
            log.info("不存在session，设置browser={}",browser);
        }else {
            log.info("存在session，browser={}",sessionBrowser.toString());
        }
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                log.info("Cookie :{}-- {}",cookie.getName(),cookie.getValue());
            }
        }
        return "index";
    }
}
