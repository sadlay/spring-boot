package com.lay.springboot.springsecurity.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 19:25 2019/1/3
 * @Modified By:IntelliJ IDEA
 */
@Component
public class OverwriteXmlPlugin extends PluginAdapter {


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        sqlMap.setMergeable(false);
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }
}
