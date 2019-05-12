package com.lay.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 22:45 2019/5/9
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class SuibianController {

    @GetMapping("/suibian")
    public String suibian(){
        System.out.println("");
        return "suibian";
    }
}
