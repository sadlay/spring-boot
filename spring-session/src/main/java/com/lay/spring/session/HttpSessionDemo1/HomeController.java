package com.lay.spring.session.HttpSessionDemo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 12:34 2019/1/16
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "Hello World! This is Spring Session Tomcat1";
    }
}
