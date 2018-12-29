package com.lay.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:文件上传控制器
 * @Author: lay
 * @Date: Created in 19:55 2018/11/14
 * @Modified By:IntelliJ IDEA
 */
@Controller
public class FileController {
    /**
     *
     * @Description:上传页面
     * @param: []
     * @return: java.lang.String
     * @auther: lay
     * @date: 11:09 2018/11/15
     */
    @GetMapping("/upload/page")
    public String uploadPage(){
        return "/file/upload";
    }
    /**
     *
     * @Description: 使用HttpServletRequest作为参数
     * @param: [request]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: lay
     * @date: 11:10 2018/11/15
     */
    @PostMapping("/upload/request")
    @ResponseBody
    public Map<String,Object> uploadRequest(HttpServletRequest request){
        boolean flag=false;
        MultipartHttpServletRequest mreq=null;
        //强制转换为MultipartHttpServletRequest接口对象
        if(request instanceof MultipartHttpServletRequest){
            mreq=(MultipartHttpServletRequest)request;
        }else {
            return dealResultMap(false,"上传失败");
        }
        //获取MultipartFile文件
        MultipartFile mf=mreq.getFile("file");
        //获取源文件名称
        String fileName=mf.getOriginalFilename();
        File file=new File(fileName);
        try {
            //保存文件
            mf.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
            return dealResultMap(false,"上传失败");
        }
        return dealResultMap(true,"上传成功");
    }

    //使用Spring MVC 的MultipartFille类作为参数
    @PostMapping("/upload/multipart")
    @ResponseBody
    public Map<String,Object> uploadMultipartFile(MultipartFile file){
        String fileName=file.getOriginalFilename();
        File dest=new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResultMap(false,"上传失败");
        }
        return dealResultMap(true,"上传成功");
    }
    /**
     *
     * @Description: 使用Part接口作为参数
     * @param: [success, msg]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: lay
     * @date: 10:36 2018/11/15
     */
    @PostMapping("/upload/part")
    @ResponseBody
    public Map<String,Object> uploadPart(Part file){
        //获取提交文件名称
        String fileName=file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResultMap(false,"上传失败");
        }
        return dealResultMap(true,"上传成功");
    }
    /**
     *
     * @Description: 处理上传文件结果
     * @param: [success, msg]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: lay
     * @date: 10:50 2018/11/15
     */
    private Map<String,Object> dealResultMap(boolean success,String msg){
        Map<String,Object> result=new HashMap<>();
        result.put("success",success);
        result.put("msg",msg);
        return result;
    }


}
