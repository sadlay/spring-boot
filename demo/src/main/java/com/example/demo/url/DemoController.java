package com.example.demo.url;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:05 2019/5/9
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class DemoController {

    @GetMapping("/test")
    public String test(){
        return "/test";
    }
}
