package com.lay.springboot_aop.intercept;

import java.lang.reflect.InvocationTargetException;

import com.lay.springboot_aop.invoke.Invocation;




public interface Interceptor {
    //前方法
    public  boolean before();
    
    //后方法
    public void after();
    
    /**
     * 取代原有事件的方法
     * @param invocation 回调参数，可以通过它的proceed方法，回调原有事件
     * @return 原有事件的返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Date        2018年10月23日 下午4:12:13 
     * @Author      lay
     */
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    
    //是否返回方法。事件没有发生异常执行
    public void afterReturning();
    
    //事后异常方法，当事件发生异常时执行
    public void afterThrowing();
    
    //是否使用around()方法取代原有方法
    boolean useAround();
}
