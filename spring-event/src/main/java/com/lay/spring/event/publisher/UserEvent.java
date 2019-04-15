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
public class UserEvent<T> extends BaseEvent {

    public UserEvent(String userName) {
        super(userName, true);
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
        UserEvent userEvent = (UserEvent) o;
        return Objects.equals(userName, userEvent.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    public static void main(String[] args) {
        UserEvent userEvent = new UserEvent("123");
        UserEvent userEvent2 = new UserEvent("123");
        System.out.println(userEvent.equals(userEvent2));

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "123");
        map.put(2, "234");
        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(1, "123");
        map2.put(2, "234");
        System.out.println(map.equals(map2));
    }
}
