package com.lay.ioc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lay.ioc.IocApplication;
import com.lay.ioc.pojo.Programmer;
import com.lay.ioc.pojo.definiion.Person;

public class IoCTest {
    private static Logger log = LoggerFactory.getLogger(IocApplication.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
//        ScopeBean scopeBean1=ctx.getBean(ScopeBean.class);
//        ScopeBean scopeBean2=ctx.getBean(ScopeBean.class);
//        System.out.println(scopeBean1==scopeBean2);
//        DataBasePropertiesTwo two=ctx.getBean(DataBasePropertiesTwo.class);
//        System.out.println(two.getDriverName());
        Person person=ctx.getBean(Programmer.class);
        //person.activity();
        ctx.close();
    }
    
}
