package com.lay.pojo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lay.converter.SexConverter;
import com.lay.enumeration.SexEnum;

//指明User是一个实体
@Entity(name = "user")
//定义映射的表
@Table(name = "t_user")
public class User {
    //表明主键
    @Id
    //策略为递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    
    //定义属性和表的映射关系
    @Column(name = "user_name")
    private String userName = null;
    
    //定义转换器
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;//枚举
    
    private String note = null;
    
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
