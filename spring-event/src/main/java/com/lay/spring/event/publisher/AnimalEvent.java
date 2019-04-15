package com.lay.spring.event.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:37 2019/4/9
 * @Modified By:IntelliJ IDEA
 */
public class AnimalEvent<T> extends BaseEvent {

    public AnimalEvent(String userName) {
        super(userName, false);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public boolean isUserEvent() {
        return isUserEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEvent userEvent = (AnimalEvent) o;
        return Objects.equals(userName, userEvent.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

}
