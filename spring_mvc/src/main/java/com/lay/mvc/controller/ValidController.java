package com.lay.mvc.controller;

import com.lay.mvc.entity.Person;
import com.lay.mvc.pojo.ValidatorPojo;
import com.lay.mvc.validator.PersonValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:33 2018/11/13
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class ValidController {

    /**
     *
     * @Description: 验证页面
     * @param: []
     * @return: java.lang.String
     * @auther: lay
     * @date: 17:34 2018/11/13
     */
    @GetMapping("/valid/page")
    public String validPage(){
        return "validator/pojo";
    }

    /**
     *
     * @Description: 解析验证参数错误
     * @param: validatorPojo 需要验证的POJO，使用注解@Valid表示验证
     * @param  errors 错误信息，它由Spring MVC通过验证POJO后自动填充
     * @return: java.util.Map<java.lang.String,java.lang.Object> 错误信息
     * @auther: lay
     * @date: 17:43 2018/11/13
     */
    @RequestMapping(value ="/valid/validate")
    @ResponseBody
    public Map<String,Object> validate(
            @Valid @RequestBody ValidatorPojo validatorPojo, Errors errors){
        Map<String,Object> errMap=new HashMap<>();
        //获取错误列表
        List<ObjectError> oes=errors.getAllErrors();
        for(ObjectError oe:oes){
            String key=null;
            String msg=null;
            //字段错误
            if(oe instanceof FieldError){
                FieldError fe= (FieldError) oe;
                key=fe.getField();//获取错误验证字段名
            }else {
                //非字段错误
                key=oe.getObjectName();//获取验证对象名称
            }
            //错误信息
            msg=oe.getDefaultMessage();
            errMap.put(key,msg);
        }
        return  errMap;
    }
    /**
     *
     * @Description:调用控制器前执行这个方法
     * @param: [webDataBinder]
     * @return: void
     * @auther: lay
     * @date: 18:39 2018/11/13
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //绑定验证器
        webDataBinder.setValidator(new PersonValidator());
        //定义日期格式参数，参数不再需要注解@DateTimeFormat，boolean参数表示是否允许为空
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    /**
     *
     * @Description: 解析验证参数错误
     * @param: validatorPojo 需要验证的POJO，使用注解@Valid表示验证
     * @param  errors 错误信息，它由Spring MVC通过验证POJO后自动填充
     * @return: java.util.Map<java.lang.String,java.lang.Object> 错误信息
     * @auther: lay
     * @date: 17:43 2018/11/13
     */
    @RequestMapping(value ="/valid/personValid")
    @ResponseBody
    public Map<String,Object> personValid(
            @Valid Person person, Errors errors,Date date){
        Map<String,Object> map=new HashMap<>();
        map.put("person",person);
        map.put("date",date);
        //获取错误列表
        List<ObjectError> oes=errors.getAllErrors();
        for(ObjectError oe:oes){
            String key=null;
            String msg=null;
            //字段错误
            if(oe instanceof FieldError){
                FieldError fe= (FieldError) oe;
                key=fe.getField();//获取错误验证字段名
            }else {
                //非字段错误
                key=oe.getObjectName();//获取验证对象名称
            }
            //错误信息
            msg=oe.getDefaultMessage();
            map.put(key,msg);
        }
        return  map;
    }
}
