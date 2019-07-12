package com.example.demo.controller;

import com.example.demo.core.IpHolder;
import com.example.demo.core.UserHolder;
import com.example.demo.session.MySession;
import com.example.demo.session.SessionContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:33 2019/6/7
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class MyController {

    @GetMapping("/login")
    public String login(String name, String password, HttpServletRequest request, HttpServletResponse response) {

        User user = new User("張三", "888888", "男");
        String token = UUID.randomUUID().toString();
        MySession mySession = SessionContainer.get(request, response);

        mySession.set("login", true);
        mySession.set("name", name);
        return token;
    }

    @GetMapping("/isLogin")
    public String isLogin(HttpServletRequest request, HttpServletResponse response) {
        MySession mySession = SessionContainer.get(request, response);
        Boolean login = (Boolean) mySession.get("login");
        String name = null;
        if (login != null) {
            if (login) {
                name = (String) mySession.get("name");
            }
        }
        return "success :" + name;
    }

    @GetMapping("/local")
    public String local() {
        User user = UserHolder.get();
        String userName = user.getUserName();
        String password = user.getPassword();
        System.out.println(IpHolder.get());
        return "success ! userName:" + userName + "  password: " + password;
    }
}
