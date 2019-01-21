package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.entity.TUser;
import com.lay.springboot.beetl.service.UserService;
import org.beetl.sql.core.engine.PageQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.List;

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


    @Test
    public void testGetUserByIdGreat(){
        List<TUser> users=userService.getUsersByIdGreat(1);
        System.out.println(users);
    }

    @Test
    public void testGetUsers(){
        TUser tUser=new TUser();

        PageQuery<TUser> usersQuery = userService.getUsers(tUser);
        List<TUser> userList = usersQuery.getList();
        System.out.println(userList);
        System.out.println(MessageFormat.format("pageNumber:{0}  pageSize{1}  totalPage{2}",usersQuery.getPageNumber(),usersQuery.getPageSize(),usersQuery.getTotalPage()));

    }

    @Test
    public void getUserAllById(){

        TUser userAllById = userService.getUserAllById(1);
        System.out.println(userAllById);
    }

}