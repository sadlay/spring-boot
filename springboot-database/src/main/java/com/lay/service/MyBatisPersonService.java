package com.lay.service;

import java.util.List;

import com.lay.pojo.Person;

public interface MyBatisPersonService {
    public Person getPerson(Long id);
    
    public int insertPerson(Person person);
    
    public int batchPerson(List<Person> personList);
    
}
