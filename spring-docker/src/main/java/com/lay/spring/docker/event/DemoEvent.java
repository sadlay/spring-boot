package com.lay.spring.docker.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:47 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
public class DemoEvent extends ApplicationEvent {
    private String message;

    public DemoEvent(Object source,String message) {
        super(source);
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
