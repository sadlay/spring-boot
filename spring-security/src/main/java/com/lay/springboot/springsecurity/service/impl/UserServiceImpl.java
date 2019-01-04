package com.lay.springboot.springsecurity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lay.springboot.springsecurity.dao.UserMapper;
import com.lay.springboot.springsecurity.model.User;
import com.lay.springboot.springsecurity.model.UserExample;
import com.lay.springboot.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:18 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        int result=userMapper.insert(user);
        result=user.getId();
        return result;
    }

    @Override
    public PageInfo<User> allUser(UserExample userExample) {
        PageHelper.startPage(userExample.getPageNum(),userExample.getPageSize());
        List<User> userList=userMapper.selectByExample(userExample);
        PageInfo pageInfo=new PageInfo(userList);
        return pageInfo;
    }
}
