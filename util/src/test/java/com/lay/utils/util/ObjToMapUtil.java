package com.lay.utils.util;

import com.alibaba.fastjson.JSONObject;
import com.lay.utils.util.testpojo.User;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:01 2019/1/11
 * @Modified By:IntelliJ IDEA
 */
public class ObjToMapUtil {
    public static User buildUder(){
        User user=new User();
        user.setId(1L);
        user.setUserName("周星驰");
        user.setPassword("this a password");
        user.setGender(1);
        user.setBirthday(null);
        user.setNote("the king of comedy");
        return user;
    }

    public static Map<String,Object> buildMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",2L);
        map.put("userName","莱昂纳多");
        map.put("passWord","this is not a password");
        map.put("gender","0");
        map.put("birthday", DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
        map.put("note","泰坦尼克号");
        return map;
    }

    public static  void printToString(Object o){
        String objectString=JSONObject.toJSONString(o);
        System.out.println(objectString);
    }

    public static void main(String[] args) throws Exception {
        Map map=buildMap();
        printToString(map);
        User user= (User) com.lay.utils.util.convert.ObjToMapUtil.mapToObject(map,User.class);
        printToString(user);
    }
}
