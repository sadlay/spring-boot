package com.lay.spring.event.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:32 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
public class EventPublishUtil implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public static ApplicationEventPublisher getEventPublisher() {
        return applicationEventPublisher;
    }

    public static void publish(Object o) {
        applicationEventPublisher.publishEvent(o);
    }

    public static void publish(ApplicationEvent applicationEvent) {
        applicationEventPublisher.publishEvent(applicationEvent);
    }
}
