package com.lay.mvc.controller;

import com.lay.mvc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:21 2018/11/15
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class HeaderController {

    @GetMapping("/header/page")
    public String headerPage(){
        return "/header/testheader";
    }
    @PostMapping("/header/person")
    @ResponseBody
    public Person headerPerson(@RequestHeader("id") Long id){
        Person person=new Person();
        person.setId(id);
        person.setPersonName("花花");
        return person;
    }
}
