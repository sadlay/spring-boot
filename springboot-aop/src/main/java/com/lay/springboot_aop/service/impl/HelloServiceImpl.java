package com.lay.springboot_aop.service.impl;

import com.lay.springboot_aop.service.HelloService;

public class HelloServiceImpl implements HelloService {
    
    @Override
    public void sayHello(String name) {
        if (name == null && name.trim() == "") {
            throw new RuntimeException("name is null!!!");
        }
        System.out.println("hello   " + name);
    }
    
    @Override
    public String sayBye(String words) {
        System.out.println("Bye   " + words);
        return words;
    }
}
