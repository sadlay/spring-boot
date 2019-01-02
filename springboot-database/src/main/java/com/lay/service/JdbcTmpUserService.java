package com.lay.service;

import java.util.List;

import com.lay.pojo.User;

public interface JdbcTmpUserService {
    
    public User getUser(Long id);
    
    public List<User> findUsers(String userName, String note);
    
    public int insertUser(User user);
    
    public int updateUser(User user);
    
    public int deleteUser(Long id);
    
}
