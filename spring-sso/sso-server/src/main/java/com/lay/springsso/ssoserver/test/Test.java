package com.lay.springsso.ssoserver.test;

import com.lay.springsso.ssoserver.entity.TokenSession;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 9:11 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class Test {
    public static void main(String[] args){
        System.out.println("main thread:"+Thread.currentThread().getId()+" start");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TokenSession tokenSession = LocalUtil.getTokenSession();
                System.out.println("thread1:"+Thread.currentThread().getId()+" "+tokenSession.getToken()+" "+tokenSession.getUserName());
                tokenSession.setUserName("username2");
                TokenSession tokenSession3=LocalUtil.getTokenSession();
                System.out.println("thread1:"+Thread.currentThread().getId()+" "+tokenSession3.getToken()+" "+tokenSession3.getUserName());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TokenSession tokenSession = LocalUtil.getTokenSession();
                System.out.println("thread2:"+Thread.currentThread().getId()+" "+tokenSession.getToken()+" "+tokenSession.getUserName());
            }
        });

        for(int i=0;i<5;i++){

            try {
                System.out.println("thread1 state: "+thread1.getState());
                thread1.start();
                Thread.sleep(2000L);
                System.out.println("thread2 state: "+thread2.getState());
                Object o = Executors.newFixedThreadPool(1).submit(() -> {
                    System.out.println("111");
                }).get();
                thread2.start();
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }

}
