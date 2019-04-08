package com.lay.spring.event.handler;


import org.springframework.util.ErrorHandler;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:54 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
public class MyErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable throwable) {
        System.out.println("事件失败了，error message:"+throwable.getMessage()+"   "+throwable.getStackTrace());
        throwable.printStackTrace();
    }
}
