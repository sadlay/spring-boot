package com.lay.utils.util.testpojo;


import java.util.Date;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:04 2019/1/11
 * @Modified By:IntelliJ IDEA
 */
public class User {

    private Long id;
    private String userName;
    private String password;
    private Integer gender;
    private Date birthday;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
