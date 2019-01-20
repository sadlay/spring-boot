package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.entity.TUser;
import com.lay.springboot.beetl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:14 2019/1/20
 * @Modified By:IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetUserById(){
        TUser user=userService.getUserById(1);
        System.out.println(user);
    }

}