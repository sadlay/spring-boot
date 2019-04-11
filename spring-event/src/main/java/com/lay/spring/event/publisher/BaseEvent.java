package com.lay.spring.event.publisher;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:46 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
public abstract class BaseEvent {
    protected String userName;

    public BaseEvent(String userName) {
        this.userName = userName;
    }

    public abstract String getUserName();
}
