package com.lay.mvc.service.impl;

import com.lay.mvc.dao.db1.PersonDao;
import com.lay.mvc.dao.db2.PersonDao2;
import com.lay.mvc.entity.Person;
import com.lay.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:40 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonDao personDao ;


    @Autowired
    PersonDao2 personDao2;

    @Override
    @Transactional
    public Person getPerson(Long id) {
        return personDao.getPerson(id);
    }

    @Override
    @Transactional
    public Person getDb2Person(Long id) {
        return personDao2.getPerson(id);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, propagation = Propagation.REQUIRES_NEW)
    public Person insertPerson(Person person) {
        personDao.insertPerson(person);
        return person;
    }

    @Override
    @Transactional
    public Person updatePerson(Long id, String personName) {
        Person person = this.getPerson(id);
        if (person == null) {
            return null;
        }
        person.setPersonName(personName);
        personDao.updatePerson(person);
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public List<Person> findPersons(String personName, String note) {
        return personDao.findPersons(personName,note);
    }

    @Override
    @Transactional
    public int deletePerson(Long id) {
        return personDao.deletePerson(id);
    }

}
