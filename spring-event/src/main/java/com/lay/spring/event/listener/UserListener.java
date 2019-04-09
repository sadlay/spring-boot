package com.lay.spring.event.listener;

import com.lay.spring.event.publisher.AnimalEvent;
import com.lay.spring.event.publisher.BaseEvent;
import com.lay.spring.event.publisher.DemoEvent;
import com.lay.spring.event.publisher.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:38 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
@Component
public class UserListener {
    private static final Logger log = LoggerFactory.getLogger(UserListener.class);

    @EventListener
    public void onUserEvent(UserEvent userEvent) {
        String userName = userEvent.getUserName();
        log.info("UserListener :{}", userName);
    }

    @EventListener(condition = "#userEvent.userName.equals('lay')")
    public DemoEvent onUser2Event(UserEvent userEvent) {
        String userName = userEvent.getUserName();
        log.info("UserListener2  :{}", userName);
        return new DemoEvent(this,userName);
    }

    @EventListener(condition = "#animalEvent.eventType=='INSERT'")
    public void onAnimalInsertTEvent(AnimalEvent animalEvent) {
        String userName = animalEvent.getUserName();
        log.info("onAnimalEvent INSERT :{}", userName);
    }

    @EventListener(condition = "#animalEvent.eventType=='UPDATE'")
    public void onAnimalUpdateEvent(AnimalEvent animalEvent) {
        String userName = animalEvent.getUserName();
        log.info("onAnimalEvent UPDATE :{}", userName);
    }
}
