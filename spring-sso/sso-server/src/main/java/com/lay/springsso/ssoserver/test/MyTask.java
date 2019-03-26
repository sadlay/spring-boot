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
        LocalUtil.set(new TokenSession("token1", "username1"));
        TokenSession tokenSession = LocalUtil.getTokenSession();
        System.out.println("thread:" + Thread.currentThread().getId() + " " + tokenSession.getToken() + " " + tokenSession.getUserName());
        tokenSession.setUserName("username2");
        //LocalUtil.remove();
        TaskService service = new TaskService();
        service.service();
    }

    public static void main(String[] args) throws InterruptedException {
/*        MyTask myTask=new MyTask();
        Thread thread1=new Thread(myTask);
        Thread thread2=new Thread(myTask);
        thread1.start();
        thread2.start();*/
/*        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        for(int i=0;i<5;i++){
            scheduledExecutorService.execute(myTask);
        }
        scheduledExecutorService.shutdown();*/
        testStaticSession();
//        testLocalSession();
    }

    public static void testStaticSession() throws InterruptedException {
        new Thread(() -> {
            TokenSession tokenSession = new TokenSession("token1", "username1");
            LocalUtil.setStaticSession(tokenSession);
            System.out.println("thread normal :" + Thread.currentThread().getId() + " " +"set tokenSession");
            TokenSession staticSession = LocalUtil.getStaticSession();
            System.out.println("thread normal:" + Thread.currentThread().getId() + " " + staticSession.getUserName());

        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            TokenSession staticSession = LocalUtil.getStaticSession();
            System.out.println("thread normal:" + Thread.currentThread().getId() + " " + staticSession.getUserName());
            staticSession.setUserName("userName2");

        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            TokenSession staticSession = LocalUtil.getStaticSession();
            System.out.println("thread normal:" + Thread.currentThread().getId() + " " + staticSession.getUserName());
        }).start();

    }

    public static void testLocalSession() throws InterruptedException {
        new Thread(() -> {
            TokenSession tokenSession = new TokenSession("token1", "username1");
            LocalUtil.set(tokenSession);
            System.out.println("thread local :" + Thread.currentThread().getId() + " " +"set tokenSession");
            TokenSession localSession = LocalUtil.getTokenSession();
            System.out.println("thread local :" + Thread.currentThread().getId() + " " + localSession.getUserName());
        }).start();
        Thread.sleep(1000);

        new Thread(() -> {
            TokenSession localSession = LocalUtil.getTokenSession();
            System.out.println("thread local :" + Thread.currentThread().getId() + " " + localSession.getUserName());
            localSession.setUserName("userName3");

        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            TokenSession localSession = LocalUtil.getTokenSession();
            System.out.println("thread local :" + Thread.currentThread().getId() + " " + localSession.getUserName());
        }).start();

    }
}
