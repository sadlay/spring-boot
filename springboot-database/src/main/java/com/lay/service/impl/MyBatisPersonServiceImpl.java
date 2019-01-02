package com.lay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lay.dao.MyBatisPersonDao;
import com.lay.pojo.Person;
import com.lay.service.MyBatisPersonService;

@Service
public class MyBatisPersonServiceImpl implements MyBatisPersonService {
    
    @Autowired
    MyBatisPersonDao myBatisPersonDao;
    
    @Override
    public Person getPerson(Long id) {
        return myBatisPersonDao.getPerson(id);
    }
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, propagation = Propagation.REQUIRES_NEW)
    public int insertPerson(Person person) {
        System.out.println("===========sex==========" + person.getSex().getId());
        return myBatisPersonDao.insertPerson(person);
    }
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int batchPerson(List<Person> personList) {
        int count = 0;
        for (Person p : personList) {
            count += insertPerson(p);
        }
        return count;
    }
    
}
