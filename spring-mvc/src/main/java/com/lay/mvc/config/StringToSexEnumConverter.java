package com.lay.mvc.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.lay.mvc.enumeration.SexEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description:自定义性别转换器
 * @Author: lay
 * @Date: Created in 22:10 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
@Component
public class StringToSexEnumConverter implements Converter<String, SexEnum> {
    @Override
    public SexEnum convert(String source) {
        String value=source.trim();
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return SexEnum.getEnumById(Integer.parseInt(value));
    }
}
