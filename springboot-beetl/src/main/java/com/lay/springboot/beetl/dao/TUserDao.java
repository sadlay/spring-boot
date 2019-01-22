package com.lay.springboot.beetl.dao;

import com.lay.springboot.beetl.entity.TUser;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:28 2019/1/18
 * @Modified By:IntelliJ IDEA
 */
public interface TUserDao extends BaseMapper<TUser> {

    default List<TUser> listChildren(Integer userId){
        return createLambdaQuery()
                .andNotEq(TUser::getId,1)
                .andEq(TUser::getNote,"ss")
                .select();
    }

    default List<TUser> getUsersByIdGreat(Integer id){
        return createLambdaQuery()
                .andGreat(TUser::getId,id)
                .select();
    }
    default PageQuery<TUser> getUsers(TUser user){
        return createLambdaQuery()
                .andEq(TUser::getNote,null)
                .page(1,2);
    }

}
