package com.lay.springboot.beetl.service;

import com.lay.springboot.beetl.entity.TRole;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:01 2019/1/21
 * @Modified By:IntelliJ IDEA
 */
public interface RoleService {
    public TRole getRoleAllById(Integer id);

    public PageQuery<TRole> selectTRole(int pageNum,int pageSize);
}
