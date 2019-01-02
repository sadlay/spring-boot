package com.lay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lay.enumeration.SexEnum;
import com.lay.pojo.User;
import com.lay.service.JdbcTmpUserService;

@RestController
@RequestMapping(value = "/user")
public class JdbcTemplateController {
    
    @Autowired
    JdbcTmpUserService userService;
    
    @RequestMapping(value = "/insert")
    public String insertUser() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setSex(SexEnum.getEnumByName("男"));
        user.setNote("i love u");
        int result = userService.insertUser(user);
        return result + "";
    }
}
