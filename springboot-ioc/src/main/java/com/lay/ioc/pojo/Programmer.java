package com.lay.ioc.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.lay.ioc.pojo.definiion.Person;
import com.lay.ioc.pojo.definiion.Shoes;

@Component
public class Programmer implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    //@Autowired
    private Shoes shoes = null;
    
    @Override
    public void activity() {
        this.shoes.put();
    }
    
    @Override
    @Autowired
    @Qualifier("basketShoes")
    public void setShoes(Shoes shoes) {
        System.out.println("延迟依赖注入");
        this.shoes = shoes;
    }
    
    @Override
    public void setBeanName(String name) {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanNameAware的setBeanName()方法");
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanFactoryAware的setBeanFactory()方法");
    }
    

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContextAware的setApplicationContext()方法");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用InitializingBean的afterPropertiesSet()方法");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用注解@PostConstruct定义的自定义初始化方法");
    }
    
    @PreDestroy
    public void destroy1() {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用 注解@PreDestroy定义的自定义销毁方法");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用DisposableBean的destroy()方法");
    }

}
