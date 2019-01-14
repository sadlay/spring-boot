package com.lay.spring.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 20:09 2019/1/8
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class DockerController {
    @RequestMapping("/")
    public String index(){
        return "Hello Docker!";
    }

    @RequestMapping("/home")
    public String home(){
        return "Home!";
    }

}
