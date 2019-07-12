package com.example.demo.service;

import com.example.demo.controller.User;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 1:49 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
@Service
public class TokenService {

    public User getUserFromToken(String token) {
        if ("123456".equals(token)) {
            return new User("張三", "888888", "男");
        }
        return null;
    }
}
