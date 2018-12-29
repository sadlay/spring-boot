package com.lay.springboot_aop.aspect.validator.impl;

import com.lay.springboot_aop.aspect.pojo.User;
import com.lay.springboot_aop.aspect.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {
    
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口" + UserValidator.class.getSimpleName());
        return user != null;
    }
    
}
