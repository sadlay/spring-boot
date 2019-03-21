package com.lay.log.core.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:42 2019/3/20
 * @Modified By:IntelliJ IDEA
 */
@Aspect
public class ControllerAop {
    private static final Logger log = LoggerFactory.getLogger(ControllerAop.class);

    private static ThreadLocal<Long> TIME_COUNT = new ThreadLocal<>();

    @Pointcut("execution(* *..controller.*.*(..))")
    public void cutController() {
    }

    @Before("cutController()")
    public void before() {
        long startTime = System.currentTimeMillis();
        TIME_COUNT.set(startTime);
        log.info("计时开始：{}", startTime);
    }

    @After("cutController()")
    public void after() {
        Long startTime = TIME_COUNT.get();
        log.info("一共用时：{}", System.currentTimeMillis() - startTime);
    }

}
