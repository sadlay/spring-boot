package com.lay.springboot.springsecurity.service.impl;

import com.lay.springboot.springsecurity.model.Role;
import com.lay.springboot.springsecurity.model.User;
import com.lay.springboot.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:44 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //获取数据库用户信息
        User user=userService.getUserByName(userName);
        //获取数据库角色信息
        List<Role> roles = userService.findRolesByUserName(userName);
        //将信息转换为UserDetails对象

        return changeToUser(user,roles);
    }

    private UserDetails changeToUser(User user, List<Role> roles) {
        List<GrantedAuthority> authorityList=new ArrayList<>();
        //赋予查询到的角色
        for (Role role : roles) {
            GrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
            authorityList.add(authority);
        }
        //创建UserDetails对象，设置用户名密码和权限
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getUserName(), user.getPwd(), authorityList);
        return userDetails;
    }


}
