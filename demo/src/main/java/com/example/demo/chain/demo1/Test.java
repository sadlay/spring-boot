package com.example.demo.chain.demo1;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:41 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
public class Test {

    public static void main(String[] args) {
        String msg = "赵庚生是个笨蛋和猪！";
        String replaceMsg = msg.replaceAll("猪", "*");
        System.out.println(replaceMsg);
    }
}
