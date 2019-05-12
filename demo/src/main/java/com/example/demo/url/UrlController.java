package com.example.demo.url;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:19 2019/4/24
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class UrlController {

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) throws UnsupportedEncodingException {
        String requestUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        ModelMap modelMap = new ModelMap();
        String redirectUrl = "https://www.baidu.com/s?wd=" + URLEncoder.encode("财务", "UTF-8");
        String token = "xxx.yy.cc";
        modelMap.addAttribute("token", token);
        modelMap.addAttribute("redirectUrl", redirectUrl);
        String url="http://172.24.0.32:8005/#/wel/index";
        String url2="http://localhost:8005/%23/wel/index";
        ModelAndView modelAndView = new ModelAndView("redirect:"+url2, modelMap);
        Map<String, Object> model = modelAndView.getModel();
        ModelMap modelMap1 = modelAndView.getModelMap();
        String s = modelMap.toString();
        System.out.println(s);
        String s1 = modelAndView.toString();
        System.out.println(s1);
        return modelAndView;
    }

    @RequestMapping("/index2")
    public String index2(HttpServletRequest request) throws UnsupportedEncodingException {
        String requestUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();

//        String redirectUrl = "https://www.baidu.com/s?wd=" + URLEncoder.encode("财务", "UTF-8");
        String token = "xxx.yy.cc";
//        redirectAttributes.addAttribute("token", token);
//        redirectAttributes.addAttribute("redirectUrl", redirectUrl);
        return "redirect:http://localhost:8081/#/wel/index" + "?token=" + token;
    }

    @RequestMapping("/#/wel/index")
    public String urlTest(HttpServletRequest request, RedirectAttributes attributes) throws UnsupportedEncodingException {
        String requestUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String url = "http://localhost:8080/url?token=xx.yy.zz&redirectUrl=https://www.baidu.com/s?wd=财务";
        String token = request.getParameter("token");
        String redirectUrl = request.getParameter("redirectUrl");
        attributes.addAttribute("redirectUrl", redirectUrl);
        return "redirect:http://localhost:8080/receiveUrl";
    }

    @RequestMapping("receiveUrl")
    public String receiveUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        String requestUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String redirectUrl = request.getParameter("redirectUrl");
        return "redirect:" + redirectUrl;
    }
}
