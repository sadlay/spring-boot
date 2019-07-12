package com.example.demo.controller;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:48 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
public class User {

    private String userName;
    private String password;
    private String sex;

    public User(String userName, String password, String sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
