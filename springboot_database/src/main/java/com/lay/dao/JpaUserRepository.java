package com.lay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lay.pojo.User;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    
    /**
     * 按用户名称模糊查询
     * @param userName
     * @return
     * @Date        2018年10月29日 下午4:58:07 
     * @Author      lay
     */
    List<User> findByUserNameLike(String userName);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     * @Date        2018年10月29日 下午4:58:45 
     * @Author      lay
     */
    User getUserById(Long id);
    
    /**
     * 按照用户名称或者备注进行模糊查询
     * @param userName
     * @param note
     * @return
     * @Date        2018年10月29日 下午4:59:57 
     * @Author      lay
     */
    List<User> findByUserNameLikeOrNoteLike(String userName, String note);
}
