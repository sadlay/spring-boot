package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.dao.TUserDao;
import com.lay.springboot.beetl.entity.TUser;
import com.lay.springboot.beetl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:11 2019/1/20
 * @Modified By:IntelliJ IDEA
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserDao userDao;
    @Override
    public TUser getUserById(Integer id) {
        TUser tUser=new TUser();
        tUser.setId(id);
        return userDao.templateOne(tUser);
    }
}
