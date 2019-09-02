package com.lay.ioc.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ScopeService1
 *
 * @Author: sadlay
 * @Date: Created in 2019/9/2 15:17
 * @Modified By:IntelliJ IDEA
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonScope {

    private int num = 0;

    public int getNum() {
        return this.num;
    }

    public void addNum() {
        this.num++;
    }
}
