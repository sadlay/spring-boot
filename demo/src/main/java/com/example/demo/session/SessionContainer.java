package com.example.demo.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:55 2019/6/7
 * @Modified By:IntelliJ IDEA
 */
public class SessionContainer {


    private static final String SESSION_ID = "My_Session_Id";
    private static Map<String, MySession> container = new HashMap<>();

    private static void set(String sessionId, MySession mySession) {
        container.put(sessionId, mySession);
    }

    public static MySession get(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String sessionId = getSessionIdFromCookies(cookies);
        MySession mySession = get(sessionId);
        if (mySession != null) {
            return mySession;
        }
        sessionId = UUID.randomUUID().toString();
        MySession mySession1 = new MySession(sessionId);
        set(sessionId, mySession1);
        setCookies(sessionId,response);
        return  mySession1;

    }

    private static void setCookies(String sessionId, HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION_ID,sessionId);
        cookie.setMaxAge(60);
        Cookie cookie2= new Cookie("token","nimasile");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }

    private static String getSessionIdFromCookies(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(SESSION_ID)) {
                return cookie.getValue();
            }
        }
        return null;
    }


    private static MySession get(String sessionId) {
        return container.get(sessionId);
    }

}
