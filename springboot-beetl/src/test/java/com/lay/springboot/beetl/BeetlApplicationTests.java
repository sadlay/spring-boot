package com.lay.springboot.beetl;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.kit.GenKit;
import org.beetl.sql.ext.gen.GenConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlApplicationTests {

    private static final Logger log= LoggerFactory.getLogger(BeetlApplicationTests.class);
    @Autowired
    SQLManager sql;

    @Test
    public void contextLoads() throws Exception {
        String table="t_user";

        //sql.genPojoCodeToConsole(table);//根据表名生成pojo类，输出到控制台
        //sql.genSQLTemplateToConsole(table);//生成查询，条件，更新sql模板，输出到控制台。
        GenConfig genConfig=new GenConfig();
        genConfig.setEncoding("UTF-8");
        //sql.genSQLFile(table,genConfig);//同上，但输出到工程，成为一个sql模版,sql模版文件的位置在src目录下，或者src／main／resources（如果是maven）工程.
        //sql.genBuiltInSqlToConsole(TUser.class);//根据类来生成内置的增删改查sql语句，并打印到控制台
        String resourcePath= GenKit.getJavaResourcePath();
        log.info("resourcePath: {}",resourcePath);

    }

}

