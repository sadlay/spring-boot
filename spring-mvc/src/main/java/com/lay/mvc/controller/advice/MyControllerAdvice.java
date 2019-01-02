package com.lay.mvc.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 定义控制器通知
 * @Author: lay
 * @Date: Created in 17:07 2018/11/15
 * @Modified By:IntelliJ IDEA
 */

@ControllerAdvice(
        //指定拦截的包
        basePackages = {"com.lay.mvc.controller.advice.test.*"},
        //限定被标注@Controller的类才被拦截
        annotations = Controller.class)
public class MyControllerAdvice {

    //绑定格式化参、参数转换规则和增加验证器
    @InitBinder
    public void initDataBinder(WebDataBinder binder){
        //自定义日期编辑器，限定格式为yyyy-Mm-dd，且参数不允许为空
        CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false);
        //注册自定义日期编辑其
        binder.registerCustomEditor(Date.class,dateEditor);
    }

    //在控制器之前线执行，可以初始化数据模型
    @ModelAttribute
    public void projectModel(Model model){
        model.addAttribute("projectName","spring_mvc");
    }

    // 异常处理，使得被拦截的控制器发生异常时，都能用相同的视图响应
    @ExceptionHandler(value = Exception.class)
    public String exception(Model model ,Exception ex){
        //给数据模型增加异常消息
        model.addAttribute("exception_message",ex.getMessage());
        //返回异常视图
        return "exception";
    }

}
