package com.lay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lay.dao.JpaUserRepository;
import com.lay.pojo.User;

@Controller
@RequestMapping(value = "/jpa")
public class JpaController {
    
    //注入JPA接口
    @Autowired
    private JpaUserRepository jpaUserRepository = null;
    
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        //使用JPA接口查询对象
        User user = jpaUserRepository.findById(id).get();
        return user;
        
    }
    
    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(Long id) {
        //使用JPA接口查询对象
        User user = jpaUserRepository.getUserById(id);
        return user;
        
    }
    
    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUserNameLike(String userName) {
        //使用JPA接口查询对象
        List<User> users = jpaUserRepository.findByUserNameLike(userName);
        return users;
        
    }
    
}
