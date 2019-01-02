package com.lay.service.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.lay.enumeration.SexEnum;
import com.lay.pojo.User;
import com.lay.service.JdbcTmpUserService;

@Service
public class JdbcTmpUserServiceImpl implements JdbcTmpUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;
    
    //获取映射关系
    private RowMapper<User> getUserMapper() {
        //使用lambda表达式创建用户映射关系
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }
    
    //获取对象
    @Override
    public User getUser(Long id) {
        //执行sql
        String sql = "select id,user_name,sex,note from t_user where id=?";
        //参数
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }
    
    //查询用户列表
    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id,user_name,sex,note fromt_user" + "where user_name like concat('%',?,'%')" + "and note like concat('%',?,'%')";
        //参数
        Object[] params = new Object[] {userName, note};
        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
        return userList;
    }
    
    //插入数据库
    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user(user_name,sex,note) values(?,?,?)";
        
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
    }
    
    //更新数据库
    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name=?,sex=?,note=?" + "where id=?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
    }
    
    //删除数据
    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id=?";
        return jdbcTemplate.update(sql, id);
    }
    
}
