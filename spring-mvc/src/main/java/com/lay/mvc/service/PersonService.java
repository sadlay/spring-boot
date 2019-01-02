package com.lay.mvc.service;

import com.lay.mvc.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:39 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
public interface PersonService {

    //获取单个用户
    public Person getPerson(Long id);

    public Person getDb2Person(Long id) ;

    //新增用户
    public Person insertPerson(Person person);

    //更新用户名
    public Person updatePerson(Long id, String personName);

    //获取全部用户
    public List<Person> getAllPersons();

    //查询用户
    public List<Person> findPersons(String personName,String note);

    //删除用户
    public int deletePerson(Long id);


}
