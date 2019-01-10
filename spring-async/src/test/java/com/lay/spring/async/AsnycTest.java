package com.lay.spring.async;

import com.lay.spring.async.service.AsyncService;
import com.sun.media.jfxmedia.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:03 2019/1/10
 * @Modified By:IntelliJ IDEA
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsnycTest {

    @Autowired
    private AsyncService asyncService;
    @Test
    public void asyncTest(){
        Future<String> future=asyncService.asyncInvokeReturnFuture(100);
        asyncService.asyncInvokeSimple();
        asyncService.asyncInvokeWtihParameter("async-test");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException ");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("ExecutionException ");
        }
        System.out.println("done");
    }
}
