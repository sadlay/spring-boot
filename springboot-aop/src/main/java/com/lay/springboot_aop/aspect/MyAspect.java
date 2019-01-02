package com.lay.springboot_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.lay.springboot_aop.aspect.pojo.User;
import com.lay.springboot_aop.aspect.validator.UserValidator;
import com.lay.springboot_aop.aspect.validator.impl.UserValidatorImpl;

@Aspect
public class MyAspect {
    
    @DeclareParents(value = "com.lay.springboot_aop.aspect.service.impl.UserServiceImpl*", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;
    
    @Pointcut("execution(* com.lay.springboot_aop.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }
    
    @Before("pointCut()&&args(user)")
    public void before(JoinPoint point ,User user) {
        Object[] args=point.getArgs();
        User a= (User)args[0];
        System.out.println("print in before"+user.getUserName());
        System.out.println("\nprint in before args = "+a.getUserName());
        System.out.println("before-----------");
    }
    
    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before-------------");
        jp.proceed();
        System.out.println("around after-------------");
    }
    
    @After("pointCut()")
    public void after() {
        System.out.println("after------------");
    }
    
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning------------");
    }
    
    @AfterThrowing("pointCut()")
    public void afterThrowning() {
        System.out.println("afterThrowning------------");
    }
}
