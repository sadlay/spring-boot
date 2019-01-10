package com.lay.spring.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:01 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean("async-Executor")
    public AsyncTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Async-Executor");
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(1000);
        executor.setCorePoolSize(10);
        executor.initialize();
        return executor;
    }
}
