package com.lay.mvc.controller.advice.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:09 2018/11/15
 * @Modified By:IntelliJ IDEA
 */
@Controller
@RequestMapping("/advice")
public class TestController {
    @GetMapping("/test")
    public String test(Date date, ModelMap modelMap){
        //从数据模型中获取数据
        String projectName = (String) modelMap.get("projectName");
        System.out.println(projectName);
        //打印日期参数
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        //抛出异常，这样转到控制器异常通知
        throw new RuntimeException("异常，跳转到控制器通知的异常信息里");
    }

}
