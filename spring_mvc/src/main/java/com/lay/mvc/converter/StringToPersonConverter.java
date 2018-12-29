package com.lay.mvc.converter;

import com.lay.mvc.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Description:自定义字符串用户转换器
 * @Author: lay
 * @Date: Created in 16:26 2018/11/13
 * @Modified By:IntelliJ IDEA
 */
@Component
public class StringToPersonConverter implements Converter<String, Person> {
    //转换方法
    @Override
    public Person convert(String s) {
        Person person=new Person();
        String[] strArr=s.split("-");
        Long id=Long.parseLong(strArr[0]);
        String personName=strArr[1];
        String note=strArr[2];
        person.setId(id);
        person.setPersonName(personName);
        person.setNote(note);
        return person;
    }
}
