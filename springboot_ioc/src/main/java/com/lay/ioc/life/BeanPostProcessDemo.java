package com.lay.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class BeanPostProcessDemo implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcess调用postProcessBeforeInitialization()方法，参数【"+bean.getClass().getSimpleName()+"】 【"+beanName+"】");
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcess调用postProcessAfterInitialization()方法，参数【"+bean.getClass().getSimpleName()+"】 【"+beanName+"】");
        return bean;
    }
}
