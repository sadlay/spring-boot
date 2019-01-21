package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.entity.TRole;
import com.lay.springboot.beetl.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(tRole);
    }

}