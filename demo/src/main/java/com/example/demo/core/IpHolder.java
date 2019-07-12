package com.example.demo.core;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 1:44 2019/6/8
 * @Modified By:IntelliJ IDEA
 */
public class IpHolder {

    private static ThreadLocal<String> ipThreadLocal = new ThreadLocal<>();

    public static void set(String ip) {
        ipThreadLocal.set(ip);
    }

    public static String get() {
        return ipThreadLocal.get();
    }

    public static void remove() {
        ipThreadLocal.remove();
    }
}
