package com.lay.converter;

import javax.persistence.AttributeConverter;

import com.lay.enumeration.SexEnum;

public class SexConverter implements AttributeConverter<SexEnum, Integer> {
    
    //将枚举转换为数据库列
    @Override
    public Integer convertToDatabaseColumn(SexEnum sex) {
        return sex.getId();
    }
    
    //將数据库列转换为枚举
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumById(id);
    }
    
}
