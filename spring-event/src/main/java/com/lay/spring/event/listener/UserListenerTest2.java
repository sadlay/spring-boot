package com.lay.spring.event.listener;

import com.lay.spring.event.publisher.AnimalEvent;
import com.lay.spring.event.publisher.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:12 2019/4/10
 * @Modified By:IntelliJ IDEA
 */
@Component
public class UserListenerTest2 implements BaseListener{

    @Override
    @EventListener
    public void onUserEvent(UserEvent userEvent) {
        System.out.println("UserListenerTest2-------UserEvent--------");
    }

    @Override
    public void onAnimalEvent(AnimalEvent userEvent) {
        System.out.println("UserListenerTest2-------AnimalEvent--------");
    }
}
