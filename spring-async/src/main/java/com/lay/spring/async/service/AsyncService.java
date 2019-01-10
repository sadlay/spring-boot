package com.lay.spring.async.service;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:07 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
public interface AsyncService {

    /**
     * 简单的异步调用返回值为void
     */
    public void asyncInvokeSimple();

    /**
     * 带参数的异步调用，异步方法可以传入参数
     * 对于返回值是void,异常会被AsyncUncaughtExceptionHandler处理
     * @param param
     */
    public void asyncInvokeWtihParameter(String param);

    /**
     * 调用异常返回Future
     * 对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，需要我们在方法中捕获异常并处理
     * 或者在调用的Future.get时候捕获异常进行处理
     * @param i
     * @return
     */
    public Future<String> asyncInvokeReturnFuture(int i);

    /**
     * 通过AsyncResult捕获异常（有返回值）
     * AsyncResult是Future接口的子类，所以也可以通过future.get()获取返回值的时候捕获ExcecutionException
     * @param i
     * @return
     */
    public AsyncResult<String> asyncInvokeWithResult(int i);
}
