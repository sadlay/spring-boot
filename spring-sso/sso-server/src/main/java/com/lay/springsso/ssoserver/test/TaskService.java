package com.lay.springsso.ssoserver.test;

import com.lay.springsso.ssoserver.entity.TokenSession;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:30 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class TaskService {

    public void service(){
        TokenSession tokenSession = LocalUtil.getTokenSession();
        System.out.println("thread:"+Thread.currentThread().getId()+"  after set username and remove  "+tokenSession.getToken()+" "+tokenSession.getUserName());
    }
}
