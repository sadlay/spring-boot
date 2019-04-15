package com.lay.spring.event.publisher;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:46 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
public abstract class BaseEvent {

    protected boolean isUserEvent;

    protected String userName;

    public BaseEvent(String userName, boolean isUserEvent) {
        this.userName = userName;
        this.isUserEvent = isUserEvent;
    }

    public abstract String getUserName();

    public abstract boolean isUserEvent();
}
