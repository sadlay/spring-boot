package com.example.demo.chain.demo2;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:50 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
public class Test {
    public static void main(String[] args) {
        String msg = "李亚男是个笨蛋and猪and笨蛋and猪";
        StringBuilder msgBuilder=new StringBuilder(msg);
        Filter zhuFilter = new ZhuFilter();
        Filter benFilter = new BenFilter();
        MsgFilterChain msgFilterChain = new MsgFilterChain()
                .add(zhuFilter)
                .add(benFilter);
        msgFilterChain.doFilter(msgBuilder);
        System.out.println(msgBuilder.toString());
    }
}
