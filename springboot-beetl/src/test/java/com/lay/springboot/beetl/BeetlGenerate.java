package com.lay.springboot.beetl;

import org.beetl.sql.core.SQLManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:13 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlGenerate {
    @Autowired
    SQLManager sqlManager;
    @Test
    public void testGenerate(){
        try {
            sqlManager.genPojoCodeToConsole("t_user");
            sqlManager.genSQLTemplateToConsole("t_user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
