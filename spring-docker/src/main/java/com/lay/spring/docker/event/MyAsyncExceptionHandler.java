package com.lay.spring.docker.event;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 12:07 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
public class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        System.out.println("调用异步任务出错了, message : " + throwable.getMessage());
    }
}
