package com.lay.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * ScopeService1
 *
 * @Author: sadlay
 * @Date: Created in 2019/9/2 15:17
 * @Modified By:IntelliJ IDEA
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScope {

    private int num = 0;

    public int getNum() {
        return this.num;
    }

    public void addNum() {
        this.num++;
    }
}
