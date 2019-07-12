package com.example.demo.core;

import com.example.demo.controller.User;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 1:44 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
public class UserHolder {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void set(User user) {
        userThreadLocal.set(user);
    }

    public static User get() {
        return userThreadLocal.get();
    }

    public static void remove() {
        userThreadLocal.remove();
    }
}
