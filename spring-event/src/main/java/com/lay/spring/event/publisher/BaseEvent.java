package com.lay.spring.event.publisher;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:46 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
public abstract class BaseEvent<T> {
    protected T userName;

    public BaseEvent(T userName) {
        this.userName = userName;
    }

    abstract T getUserName();
}
