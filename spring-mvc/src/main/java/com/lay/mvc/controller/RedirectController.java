package com.lay.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:转发与重定向控制器
 * @Author: lay
 * @Date: Created in 16:03 2018/11/15
 * @Modified By:IntelliJ IDEA
 */
@Controller
@RequestMapping("/skip")
public class RedirectController {

    //转发 不带参数
    @GetMapping("/forwardNoArgs")
    public String forwardNoArgs(){
        return "forward:/skip/forward";
    }

    //转发 带参数
    @GetMapping("/forwardWithArgs")
    public String forwardWithArgs(Long id, HttpServletRequest request){
        request.setAttribute("id",id);
        return "forward:/skip/forward";
    }


    //转发页面
    @GetMapping("/forward")
    public String forward(HttpServletRequest request, Model model){
        Long id= (Long) request.getAttribute("id");
        model.addAttribute("id",id);
        System.out.println(id);
        return "skip/forward";
    }

    //重定向 不带参数
    @GetMapping("/redirectNoArgs")
    public String redirectNoArgs(){
        return "redirect:/skip/redirect";
    }

    //重定向 url参数
    @GetMapping("/redirectWithArgs")
    public String redirectWithArgs(Long id){
        return "redirect:/skip/redirect?id="+id;
    }

    //重定向 参数为java对象
    @GetMapping("/redirectWithObject")
    public String redirectWithObject(RedirectAttributes redirectAttributes){
        long id=123;
        redirectAttributes.addAttribute("id",id);
        return "redirect:/skip/redirect";
    }

    //重定向页面
    @GetMapping("/redirect")
    public String redirect(Long id,Model model,RedirectAttributes redirectAttributes){
        model.addAttribute("id",id);
        return "/skip/redirect";
    }
}
