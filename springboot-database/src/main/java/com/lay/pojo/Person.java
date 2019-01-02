package com.lay.pojo;

import org.apache.ibatis.type.Alias;

import com.lay.enumeration.SexEnum;

// MyBatis指定别名
@Alias(value = "person")
public class Person {
    private Long id = null;
    
    private String personName = null;
    
    //性别枚举，这里需要使用typeHandler进行转换
    private SexEnum sex = null;//枚举
    
    private String note = null;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return personName;
    }
    
    public void setUserName(String personName) {
        this.personName = personName;
    }
    
    public SexEnum getSex() {
        return sex;
    }
    
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
}
