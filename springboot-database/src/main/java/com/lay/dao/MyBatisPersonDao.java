package com.lay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lay.pojo.Person;

@Mapper
public interface MyBatisPersonDao {
    
    public Person getPerson(Long id);
    
    public int insertPerson(Person person);
}
