package com.lay.springboot.springsecurity.dao;

import com.lay.springboot.springsecurity.model.Role;
import com.lay.springboot.springsecurity.model.RoleExample;
import com.lay.springboot.springsecurity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    @Select("select user_name,pwd,available " +
            "from t_user where user_name=#{userName} limit 0,1")
    public User getUserByName(String userName);

    @Select("select r.role_name " +
            "from t_user u, t_user_role ur,t_role r " +
            "where u.id=ur.user_id and r.id=ur.role_id " +
            "and u.user_name=#{userName}")
    public List<Role> findRolesByUserName(String userName);
}