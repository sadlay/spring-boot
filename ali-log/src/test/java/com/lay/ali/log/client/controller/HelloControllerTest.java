package com.lay.ali.log.client.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:32 2019/3/21
 * @Modified By:IntelliJ IDEA
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloControllerTest {
    private static final Logger log = LoggerFactory.getLogger(HelloControllerTest.class);

    /**
     * 测试单线程同步
     *
     * @param
     * @return void
     * @auther lay
     * @Date 10:49 2019/3/21
     */
    @Test
    public void testSingleAndSync() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            long singleStart = System.currentTimeMillis();
            for (int y = 0; y < 10000; y++) {
                log.info("this is info message");
            }
            System.out.print(System.currentTimeMillis() - singleStart + " ");
        }
        System.out.println("\n spend time: " + (System.currentTimeMillis() - start));
    }

    /**
     * 测试多线程同步
     *
     * @param
     * @return void
     * @auther lay
     * @Date 10:49 2019/3/21
     */
    @Test
    public void testMultiAndSync() throws InterruptedException {
        MDC.clear();
        long start = System.currentTimeMillis();
        // 使用了CountDownLatch对象，可以计算出50个线程执行完毕后所花费的总时间。
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int x = 0; x < 50; x++) {
            new Thread(() -> {
                long singleStart = System.currentTimeMillis();
                for (int y = 0; y < 10000; y++) {
                    log.info("this is info message");
                }
                System.out.print(System.currentTimeMillis() - singleStart + " ");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("\n spend time: " + (System.currentTimeMillis() - start));
    }

    /**
     * 测试单线程异步
     *
     * @param
     * @return void
     * @auther lay
     * @Date 10:49 2019/3/21
     */
    @Test
    public void testSingleAndAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int x = 0; x < 50; x++) {
            new Thread(() -> {
                long singleStart = System.currentTimeMillis();
                for (int y = 0; y < 10000; y++) {
                    log.info("this is info message");
                }
                System.out.println(System.currentTimeMillis() - singleStart + "  ");
                countDownLatch.countDown();
            }).start();
            new Thread(() -> {
                long singleStart = System.currentTimeMillis();
                for (int y = 0; y < 1000; y++) {
                    log.error("this is error message");
                }
                System.out.println(System.currentTimeMillis() - singleStart + "  ");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("all spend time" + (System.currentTimeMillis() - start));
    }


    /**
     * 测试多线程异步
     *
     * @param
     * @return void
     * @auther lay
     * @Date 10:49 2019/3/21
     */
    @Test
    public void testMultiAndAsync() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            for (int y = 0; y < 10000; y++) {
                pool.submit(() -> {
                    log.info("this is testSingleAndSync");
                    countDownLatch.countDown();
                });
            }
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }


}