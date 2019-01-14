package com.lay.spring.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:12 2019/1/14
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class FilterController {

    @RequestMapping("/filter")
    public String filter(){
        return "Filter-Controller";
    }
}
