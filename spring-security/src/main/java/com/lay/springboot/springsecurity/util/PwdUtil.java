package com.lay.springboot.springsecurity.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.ResourceBundle;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:33 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
public class PwdUtil {
    //这里使用@value,取不到properties中的值，使用工具类来读取
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    //注入配置的阴匙
    private final static String secret=resourceBundle.getString("system.user.password.secret");

    public static String encryptionPwd(String pwd){
        PasswordEncoder passwordEncoder=new Pbkdf2PasswordEncoder(secret);
        String password=passwordEncoder.encode(pwd);
        return password;
    }

    public static void main(String[] args){
        System.out.println(encryptionPwd("123"));
    }
}
