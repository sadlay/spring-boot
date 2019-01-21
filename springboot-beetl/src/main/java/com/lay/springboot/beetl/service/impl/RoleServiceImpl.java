package com.lay.springboot.beetl.service.impl;

import com.lay.springboot.beetl.entity.TRole;
import com.lay.springboot.beetl.service.RoleService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:02 2019/1/21
 * @Modified By:IntelliJ IDEA
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    SQLManager sql;
    @Override
    public TRole getRoleAllById(Integer id) {
        Map map =new HashMap();
        map.put("id",id);
        //TRole tRole = sql.selectSingle("tRole.getRoleAllById", map, TRole.class);
        TRole tRole=new TRole();
        tRole.setId(id);
        tRole=sql.templateOne(tRole);
        return tRole;
    }
}
