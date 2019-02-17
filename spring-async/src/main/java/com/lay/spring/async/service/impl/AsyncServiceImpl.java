package com.lay.spring.async.service.impl;

import com.lay.spring.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:12 2019/1/10
 * @Modified By:IntelliJ IDEA
 */


@Service
@Async("async-Executor")
public class AsyncServiceImpl implements AsyncService {
    private static final Logger log= LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    public void asyncInvokeSimple() {
        log.info("asyncInvokeSimple,线程{}",Thread.currentThread().getName()+" "+Thread.currentThread().getId());
    }

    @Override
    public void asyncInvokeWtihParameter(String param) {
        log.info("asyncInvokeWtihParameter,线程：{},参数：{}",Thread.currentThread().getName()+" "+Thread.currentThread().getId(),param);
        throw new IllegalArgumentException(param);
    }

    @Override
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture,线程：{},参数：{}",Thread.currentThread().getName()+" "+Thread.currentThread().getId(),i);
        Future<String> future=null;
        try {
            Thread.sleep(5000L);
            future=new AsyncResult<>("success："+i);
            //throw new IllegalArgumentException("a");
        }catch (InterruptedException e){
            future=new AsyncResult<>("error");
        }
        return future;
    }

    @Override
    public AsyncResult<String> asyncInvokeWithResult(int i) {
        log.info("asyncInvokeWithResult,线程：{},参数：{}",Thread.currentThread().getName()+" "+Thread.currentThread().getId(),i);
        return new AsyncResult<>("success:"+i);
    }
}
