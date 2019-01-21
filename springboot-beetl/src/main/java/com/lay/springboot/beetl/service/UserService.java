package com.lay.springboot.beetl.service;

import com.lay.springboot.beetl.entity.TUser;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:09 2019/1/20
 * @Modified By:IntelliJ IDEA
 */
public interface UserService {
    public TUser getUserById(Integer id);

    public TUser getUserAllById(Integer id);

    public List<TUser> getUsersByIdGreat(Integer id);


    public PageQuery<TUser> getUsers(TUser tUser);
}
