package com.lay.spring.event.config;

import com.lay.spring.event.handler.MyErrorHandler;
import com.lay.spring.event.util.EventPublishUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:09 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@EnableAsync
public class AsyncEventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();
        //eventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(5));
        eventMulticaster.setErrorHandler(new MyErrorHandler());
        return eventMulticaster;
    }

    @Bean
    public EventPublishUtil eventPublishUtil(){
        return new EventPublishUtil();
    }

}
