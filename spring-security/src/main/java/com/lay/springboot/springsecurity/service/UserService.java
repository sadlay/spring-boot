package com.lay.springboot.springsecurity.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lay.springboot.springsecurity.model.User;
import com.lay.springboot.springsecurity.model.UserExample;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:18 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
public interface UserService {
    public int insertUser(User user);
    public PageInfo<User> allUser(UserExample userExample);
}
