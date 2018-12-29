package com.lay.service;

import java.util.List;

import com.lay.pojo.Person;

public interface BatchService {
    public int batchInsertPerson(List<Person> personList);
}
