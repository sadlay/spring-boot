package com.lay.ali.log.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;
import javax.servlet.http.HttpFilter;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:54 2019/3/19
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("hello")
    public String hello() {
        String tag = "success";
        log.info("hello controller:{}", tag);
        if (true) {
            RuntimeException error = new RuntimeException("error");
            log.error("error", error);
            throw error;
        }
        return tag;
    }

/*    public static void main(String[] args) {
        int c = 0, k;
        for (k = 1; k < 3; k++)
            switch (k) {
                default:
                    c += k;
                case 2:
                    c++;
                    break;
                case 4:
                    c += 2;
                    break;
            }
        System.out.println(c);
    }*/
}
