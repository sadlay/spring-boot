package com.lay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lay.enumeration.SexEnum;
import com.lay.pojo.Person;
import com.lay.service.BatchService;
import com.lay.service.MyBatisPersonService;

@Controller
@RequestMapping(value = "mybatis")
public class MybatisController {
    @Autowired
    MyBatisPersonService myBatisPersonService;
    
    @Autowired
    BatchService batchService = null;
    
    @RequestMapping(value = "getPerson")
    @ResponseBody
    public Person getPerson(@RequestParam("id") Long id) {
        return myBatisPersonService.getPerson(id);
    }
    
    @RequestMapping(value = "insertPerson")
    @ResponseBody
    public int inserPerson() {
        Person person = new Person();
        person.setUserName("lisi");
        person.setSex(SexEnum.FEMALE);
        person.setNote("123");
        return myBatisPersonService.insertPerson(person);
    }
    
    @RequestMapping(value = "batchInsertPerson")
    @ResponseBody
    public int batchInsertPerson() {
        Person personA = new Person();
        personA.setUserName("lisi");
        personA.setSex(SexEnum.FEMALE);
        personA.setNote("123");
        Person personB = new Person();
        personB.setUserName("lisi2");
        personB.setSex(SexEnum.FEMALE);
        personB.setNote("123");
        List<Person> personList = new ArrayList<>();
        personList.add(personA);
        personList.add(personB);
        return myBatisPersonService.batchPerson(personList);
    }
}
