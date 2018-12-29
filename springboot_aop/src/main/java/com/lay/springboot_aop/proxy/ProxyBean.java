package com.lay.springboot_aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lay.springboot_aop.intercept.Interceptor;
import com.lay.springboot_aop.invoke.Invocation;

public class ProxyBean implements InvocationHandler{
    private Object target=null;
    private Interceptor interceptor=null;
    /**
     * 绑定代理对象
     * @param target 被代理对象  
     * @param interceptor 拦截器
     * @return 代理对象
     * @Date        2018年10月23日 下午4:56:57 
     * @Author      lay
     */
    public static Object getProxyBean(Object target,Interceptor interceptor) {
        ProxyBean proxyBean=new ProxyBean();
        //保存被代理的对象
        proxyBean.target=target;
        //保存拦截器
        proxyBean.interceptor=interceptor;
        //生成代理对象
        Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),proxyBean);
        //Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getClasses(), proxyBean);
        //返回代理对象
        return proxy;
    }

    /**
     * 处理代理对象方法逻辑
     * @param proxy 代理对象  
     * @param method 当前方法
     * @param args 运行参数
     * @return 方法调用结果
     * @throws Throwable 异常
     * @Date        2018年10月23日 下午4:56:57 
     * @Author      lay
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //异常标识
        boolean exceptionFlag=false;
        Invocation invocation=new Invocation(target, method, args);
        Object retObj=null;
        try {
            if(this.interceptor.before()) {
                retObj=this.interceptor.around(invocation);
            }else {
                retObj=method.invoke(target, args);
            }
        }catch(Exception e){
            //异常
            exceptionFlag=true;
        }
        this.interceptor.after();
        if(exceptionFlag) {
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }

    
}
