package com.lay.filedemo.controller;

import com.lay.filedemo.core.R;
import com.lay.filedemo.model.FileModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/***
 * @ClassName: DemoController
 * @Auther: zhaogengsheng
 * @Date: 2019/4/29 13:59
 * Copyright: 2018赛鼎科技-版权所有
 */
@Controller
public class DemoController {

    private static List<FileModel> fileList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        return "home.html";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        return "up.html";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return R.Result(false, "失败");
        }
        return R.Result(true, "成功");
    }

    @GetMapping("/list")
    public Object list(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        //获取参数中的filePath
        String filePath = request.getParameter("filePath");

        String rootPath = "D:\\file\\down";
        //如果参数中没有filePath，说明是首次访问，设置filePath为根目录
        if (filePath == null || filePath.isEmpty()) {
            filePath = rootPath;
        }

        //判断是否是根目录，并保存在域中，用于判断是否显示返回按钮
        if (filePath.equalsIgnoreCase(rootPath) || filePath.equalsIgnoreCase("D:\\file\\down")) {
            model.addAttribute("isRoot", true);
        } else {
            model.addAttribute("isRoot", false);
        }
        File file = new File(filePath);

        //在域中保存上级目录，用于返回上级目录
        model.addAttribute("parent", URLEncoder.encode(file.getParentFile().getPath(), "utf-8"));
        File[] files = file.listFiles();

        //先清空List再想List中添加该目录下遍历出来的文件
        fileList.clear();
        if (files != null && files.length > 0) {
            for (File file2 : files) {

                //创建自定义的保存文件关键属性的对象
                FileModel fileJavaClass = new FileModel();

                //保存文件的名字
                fileJavaClass.setName(file2.getName());

                //保存文件的绝对路径
                fileJavaClass.setPath(URLEncoder.encode(file2.getPath(), "utf-8"));

                //保存文件是文件或文件夹，用于判断文件的操作是打开还是下载
                fileJavaClass.setFile(file2.isFile());

                //添加到List中
                fileList.add(fileJavaClass);
            }
        }
        //List保存到域中
        model.addAttribute("fileList", fileList);
        return "down.html";
    }

    @GetMapping("/down")
    public void down(@RequestParam("filePath") String filePath, @RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException {
        //获取文件路径参数
        //String filePath = request.getParameter("filePath");
        //获取文件名，用于给响应头设置默认文件名
        //String fileName = request.getParameter("fileName");
        //根据文件的路径创建输入流
        InputStream in = new FileInputStream(filePath);
        //处理文件名
        fileName = URLEncoder.encode(fileName, "utf8");
        //下载文件需要给响应头设置参数
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        //获取输出流
        ServletOutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        Integer length = -1;
        while ((length = in.read(buff)) != -1) {
            out.write(buff, 0, length);
        }
        in.close();
        out.close();
    }
}
