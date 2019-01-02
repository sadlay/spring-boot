package com.lay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lay.pojo.Person;
import com.lay.service.BatchService;
import com.lay.service.MyBatisPersonService;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    MyBatisPersonService personService;
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int batchInsertPerson(List<Person> personList) {
        int count = 0;
        for (Person p : personList) {
            count += personService.insertPerson(p);
        }
        return count;
    }
    
}
