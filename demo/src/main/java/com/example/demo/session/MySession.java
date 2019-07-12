package com.example.demo.session;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:56 2019/6/7
 * @Modified By:IntelliJ IDEA
 */
public class MySession {

    private Map<String, Object> map;

    private String sessionId;

    public MySession(String sessionId) {
        this.map = new HashMap<>();
        this.sessionId = sessionId;
    }

    public void set(String key, Object value) {

        map.put(key, value);

    }

    public Object get(String key) {

        return map.get(key);
    }

    public String getSessionId() {
        return sessionId;
    }
}
