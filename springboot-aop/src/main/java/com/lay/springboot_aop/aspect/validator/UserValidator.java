package com.lay.springboot_aop.aspect.validator;

import com.lay.springboot_aop.aspect.pojo.User;

public interface UserValidator {
    public boolean validate(User user);
}
