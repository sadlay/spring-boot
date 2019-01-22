package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.entity.TRole;
import com.lay.springboot.beetl.entity.TUser;
import com.lay.springboot.beetl.service.RoleService;
import org.beetl.sql.core.engine.PageQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:08 2019/1/21
 * @Modified By:IntelliJ IDEA
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    public void getRoleAllById() {
        TRole tRole=roleService.getRoleAllById(2);
        List<TUser> userList = tRole.getUserList();
        Object userList1 = tRole.get("userList");
        System.out.println(tRole);
    }


    @Test
    public void selectTRole() {
        PageQuery<TRole> tRole= roleService.selectTRole(1,5);
        List<TRole> list = tRole.getList();
        Object userList = list.get(0).get("userList");
        System.out.println(list);
    }

}