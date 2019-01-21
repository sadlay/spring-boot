package com.lay.springboot.beetl.generate;

import com.lay.springboot.beetl.BeetlApplication;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @Description:beetlsql generate 代码自动生成
 * @Author: lay
 * @Date: Created in 15:45 2019/1/21
 * @Modified By:IntelliJ IDEA
 */
public class GenCode {
    private static final Logger log= LoggerFactory.getLogger(GenCode.class);

    //sqlManager Map
    private static final HashMap<String, SQLManager> sqlManagerMap=new HashMap<>();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BeetlApplication.class, args);
        String table="t_user";
        SQLManager sql = getSqlManager();
        GenConfig genConfig=new GenConfig();
        genConfig.setEncoding("UTF-8");
        sql.genPojoCodeToConsole(table);//根据表名生成pojo类，输出到控制台
        sql.genSQLTemplateToConsole(table);//生成查询，条件，更新sql模板，输出到控制台。
        //sql.genBuiltInSqlToConsole(TUser.class);//根据类来生成内置的增删改查sql语句，并打印到控制台

    }

    /**
     *
     * @Description: 获得sqlManager
     * @param:
     * @return: org.beetl.sql.core.SQLManager
     * @auther: lay
     * @date: 15:58 2019/1/21
     */
    public static SQLManager getSqlManager(){
        SQLManager sqlManager = sqlManagerMap.get("sqlManager");
        if(sqlManager==null){
            sqlManager=createSqlManager();
            sqlManagerMap.put("sqlManager",sqlManager);
        }
        return sqlManager;
    }

    /**
     *
     * @Description: 创建sqlManager
     * @param:
     * @return: org.beetl.sql.core.SQLManager
     * @auther: lay
     * @date: 15:58 2019/1/21
     */
    public static SQLManager createSqlManager(){
        //这里使用@value,取不到properties中的值，使用工具类来读取
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String driver=resourceBundle.getString("spring.datasource.driver-class-name");
        String url=resourceBundle.getString("spring.datasource.url");
        String userName=resourceBundle.getString("spring.datasource.username");
        String password=resourceBundle.getString("spring.datasource.password");
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        return sqlManager;
    }




}
