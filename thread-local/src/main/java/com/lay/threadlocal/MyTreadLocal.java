package com.lay.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 21:24 2019/2/17
 * @Modified By:IntelliJ IDEA
 */
public class MyTreadLocal<T> {
    private Map<Thread,T> container= Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread=Thread.currentThread();
        T value=container.get(thread);
        if(value==null&&!container.containsKey(thread)){
            value=initialValue();
            container.put(thread,value);
        }
        return value;
    }
    public void remove(){
        container.remove(Thread.currentThread());
    }

    protected T initialValue() {
        return null;
    }
}
