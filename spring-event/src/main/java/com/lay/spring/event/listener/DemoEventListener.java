package com.lay.spring.event.listener;

import com.lay.spring.event.publisher.DemoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:56 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {
    private static final Logger log = LoggerFactory.getLogger(DemoEventListener.class);

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        log.info("receiveA event:{}",demoEvent.getMessage());
    }
}
