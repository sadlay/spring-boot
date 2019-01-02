package com.lay.springboot_aop.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lay.springboot_aop.aspect.pojo.User;
import com.lay.springboot_aop.aspect.service.UserService;
import com.lay.springboot_aop.aspect.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService=null;
    
    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Integer id,String userName,String message) {
        User user=new User();
        user.setId(id);
        user.setUserName(userName);
        user.setMessage(message);
        userService.printUser(user);
        return user;
    }
    
    @RequestMapping("/vap")
    @ResponseBody
    public User validateAndPrintUser(Integer id,String userName,String message) {
        User user=new User();
        user.setId(id);
        user.setUserName(userName);
        user.setMessage(message);
        UserValidator userValidator=(UserValidator)userService;
        if(userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }
}
