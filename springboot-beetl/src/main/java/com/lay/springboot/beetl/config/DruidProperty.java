package com.lay.springboot.beetl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @Description: druid连接属性
 * @param:
 * @auther: lay
 * @date: 17:58 2019/1/18
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperty {
    private String driverClassName;//连接驱动
    private String url;//url地址
    private String username;//用户名
    private String password;//密码
    private String filter;//filter过滤
    private Integer initialSize;//初始化连接大小
    private Integer minIdle;//最小空闲连接数
    private Integer maxActive;//最大连接数

    private String druidLoginUsername;//druid sql监控登陆名
    private String druidLoginPassword; //druid sql密码

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public String getDruidLoginUsername() {
        return druidLoginUsername;
    }

    public void setDruidLoginUsername(String druidLoginUsername) {
        this.druidLoginUsername = druidLoginUsername;
    }

    public String getDruidLoginPassword() {
        return druidLoginPassword;
    }

    public void setDruidLoginPassword(String druidLoginPassword) {
        this.druidLoginPassword = druidLoginPassword;
    }
}
