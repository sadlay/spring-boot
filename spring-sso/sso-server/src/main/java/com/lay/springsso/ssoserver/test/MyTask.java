package com.lay.springsso.ssoserver.test;

import com.lay.springsso.ssoserver.entity.TokenSession;
import javafx.concurrent.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:19 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        LocalUtil.set(new TokenSession("token1","username1"));
        TokenSession tokenSession = LocalUtil.getTokenSession();
        System.out.println("thread:"+Thread.currentThread().getId()+" "+tokenSession.getToken()+" "+tokenSession.getUserName());
        tokenSession.setUserName("username2");
        LocalUtil.remove();
        TaskService service=new TaskService();
        service.service();
    }

    public static void main(String[] args){
        MyTask myTask=new MyTask();
        Thread thread1=new Thread(myTask);
        Thread thread2=new Thread(myTask);
        thread1.start();
        //thread2.start();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        for(int i=0;i<5;i++){
            scheduledExecutorService.execute(myTask);
        }
        scheduledExecutorService.shutdown();
    }
}
