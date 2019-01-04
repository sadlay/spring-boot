package com.lay.springboot.springsecurity;

import com.github.pagehelper.PageInfo;
import com.lay.springboot.springsecurity.config.PropsConfig;
import com.lay.springboot.springsecurity.model.User;
import com.lay.springboot.springsecurity.model.UserExample;
import com.lay.springboot.springsecurity.service.UserService;
import com.lay.springboot.springsecurity.util.PwdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:30 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void insertUser(){
        User user=new User();
        user.setUserName("萧峰大王2号");
        user.setPwd(PwdUtil.encryptionPwd("haima"));
        user.setNote("海草海草");
        user.setAvailable(1);
        int result=userService.insertUser(user);
        System.out.println(result);
    }
    @Test
    public void selectUser(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(2);
        userExample.or().andUserNameLike("%萧峰%");
        userExample.setPageNum(1);
        userExample.setPageSize(10);
        PageInfo<User> userPageInfo=userService.allUser(userExample);
        System.out.println(userPageInfo.getList());
    }

    @Test
    public void propsConfigTest(){
        System.out.println(PropsConfig.password.get("secret2"));
    }
}
