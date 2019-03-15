package com.lay.utils.util.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:12 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class Main2 {

    public static void main(String[] args){
        String msg="121.2";
        boolean digits = NumberUtils.isCreatable(msg);
        System.out.println(digits);
    }
}
