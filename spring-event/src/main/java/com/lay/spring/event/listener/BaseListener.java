package com.lay.spring.event.listener;

import com.lay.spring.event.publisher.AnimalEvent;
import com.lay.spring.event.publisher.UserEvent;
import org.springframework.context.event.EventListener;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:10 2019/4/10
 * @Modified By:IntelliJ IDEA
 */
public interface BaseListener {

    @EventListener
    default void onUserEvent(UserEvent userEvent){
        System.out.println("BaseListener ---------");
    }

    @EventListener
    default void onAnimalEvent(AnimalEvent userEvent){}
}
