package com.example.demo.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 22:06 2019/6/1
 * @Modified By:IntelliJ IDEA
 */
public class Order {

    public static void main(String[] args) {
        List<Integer> num = prepareNumList();
        List<String> str = prepareLetterList();

        //将原ArrayList封装为LinkedList链表
        LinkedList<Integer> numList = new LinkedList<>(num);
        LinkedList<String> strList = new LinkedList<>(str);

        int numSize = numList.size();
        int strSize = strList.size();

        //定义总List，长度为两个List的合
        ArrayList<Object> allList = new ArrayList<>(numSize + strSize);

        //获取并遍历最大的List，防止数据丢失
        int max = numSize > strSize ? numSize : strSize;
        for (int i = 0; i < max; i++) {

            //按照顺序组合
            if (!numList.isEmpty()) {

                //从链表头部弹出元素，并添加到总List集合中
                allList.add(numList.poll());
            }
            if (!strList.isEmpty()) {
                allList.add(strList.poll());
            }
            if (!numList.isEmpty()) {
                allList.add(numList.poll());
            }
        }

        for (Object o : allList) {
            System.out.print(o + "\t");
        }
    }

    private static List<Integer> prepareNumList() {
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7};
        return Arrays.asList(numArr);
    }

    private static List<String> prepareLetterList() {
        String[] letterArr = {"A", "B", "C", "D", "E"};
        return Arrays.asList(letterArr);
    }
}
