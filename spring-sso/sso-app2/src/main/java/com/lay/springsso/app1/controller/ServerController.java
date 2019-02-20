package com.lay.springsso.app1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:12 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class ServerController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello,app2";
    }
}
