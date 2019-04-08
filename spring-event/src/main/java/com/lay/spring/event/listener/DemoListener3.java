package com.lay.spring.event.listener;

import com.lay.spring.event.publisher.DemoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:13 2019/4/8
 * @Modified By:IntelliJ IDEA
 */
@Component
public class DemoListener3 {
    private static final Logger log = LoggerFactory.getLogger(DemoListener3.class);

    @EventListener
    public void onApplicaitonEvent(DemoEvent demoEvent) {
        Object source = demoEvent.getSource();
        String simpleName = source.getClass().getSimpleName();
        log.info("DemoListener3 :{}", simpleName);
    }
}
