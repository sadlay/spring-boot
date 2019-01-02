package com.lay.mvc.validator;

import com.lay.mvc.entity.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:14 2018/11/13
 * @Modified By:IntelliJ IDEA
 */
public class PersonValidator implements Validator {

    //该验证器支持Person类的验证
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    //验证逻辑
    @Override
    public void validate(Object target, Errors errors) {
        //对象为空
        if(target==null){
            //直接在参数处报错，这样就不能进入控制器的方法
            errors.rejectValue("",null,"用户不能为空");
            return;
        }
        //强制转换
        Person person=(Person)target;
        //用户名非空串
        if(StringUtils.isEmpty(person.getPersonName())){
            //增加错误，可以进入控制器方法
            errors.rejectValue("personName","null","用户名不能为空");
        }
    }
}
