package com.lay.springboot_aop.aspect.service.impl;

import org.springframework.stereotype.Service;

import com.lay.springboot_aop.aspect.pojo.User;
import com.lay.springboot_aop.aspect.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(User user) {
        if(user==null) {
            throw new RuntimeException("参数为空");
        }
        System.out.println("id = "+user.getId());
        System.out.println("id = "+user.getUserName());
        System.out.println("id = "+user.getMessage());
    }
    
}
