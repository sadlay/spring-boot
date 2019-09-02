package com.lay.ioc.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ScopeController
 *
 * @Author: sadlay
 * @Date: Created in 2019/9/2 15:16
 * @Modified By:IntelliJ IDEA
 */
@RestController
@RequestMapping("scope")
public class ScopeController {

    @Autowired
    private SingletonScope singletonScope;

    @Autowired
    private PrototypeScope prototypeScope;

    @Autowired
    private SessionScope sessionScope;

    @Autowired
    private RequestScope requestScope;


    @RequestMapping("add")
    public String add() {
        singletonScope.addNum();
        prototypeScope.addNum();
        sessionScope.addNum();
        requestScope.addNum();
        return "singleton-num:" + singletonScope.getNum() +
                "<br/>prototype-num:" + prototypeScope.getNum() +
                "<br/>session-num:" + sessionScope.getNum() +
                "<br/>request-num:" + requestScope.getNum();
    }

}
