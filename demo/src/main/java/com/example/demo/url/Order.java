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

        System.out.println("方案1=======================================================");
        List<Object> allList = assembleList(num, str);
        allList.stream().forEach((o) -> System.out.print(o + "\t"));

        System.out.println("\n方案2=======================================================");
        List<Object> allList2 = assembleList2(num, str);
        allList2.stream().forEach((o) -> System.out.print(o + "\t"));

        System.out.println("\n方案3=======================================================");
        List<Object> allList3 = assembleList3(num, str);
        allList3.stream().forEach((o) -> System.out.print(o + "\t"));

        System.out.println("\n方案4=======================================================");
        List<Object> allList4 = assembleList4(num, str);
        allList4.stream().forEach((o) -> System.out.print(o + "\t"));
    }

    private static List<Integer> prepareNumList() {
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        return Arrays.asList(numArr);
    }

    private static List<String> prepareLetterList() {
        String[] letterArr = {"A", "B", "C", "D", "E"};
        return Arrays.asList(letterArr);
    }

    private static List<Object> assembleList(List<Integer> var1, List<String> var2) {

        //将原ArrayList封装为LinkedList链表
        LinkedList<Integer> numList = new LinkedList<>(var1);
        LinkedList<String> strList = new LinkedList<>(var2);
        int numSize = numList.size();
        int strSize = strList.size();

        int allSize = numSize + strSize;

        //定义总List，长度为两个List的合
        ArrayList<Object> allList = new ArrayList<>(allSize);

        int currentNumSize = numSize / 2 + 1;

        //获取并遍历最大的List，防止数据丢失
        int max = currentNumSize > strSize ? currentNumSize : strSize;
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
        System.out.println("共循环次数:" + max);
        return allList;
    }

    private static List<Object> assembleList2(List<Integer> var1, List<String> var2) {

        //将原ArrayList封装为LinkedList链表
        LinkedList<Integer> numList = new LinkedList<>(var1);
        LinkedList<String> strList = new LinkedList<>(var2);
        int numSize = numList.size();
        int strSize = strList.size();

        //定义总List，长度为两个List的合
        int allSize = numSize + strSize;
        ArrayList<Object> allList = new ArrayList<>(allSize);

        int currentNumSize = (int) Math.ceil((double) numSize / 2);

        //获取并遍历最大的List，防止数据丢失
        int max = currentNumSize > strSize ? currentNumSize : strSize;
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
        System.out.println("共循环次数:" + max);
        return allList;
    }

    private static List<Object> assembleList3(List<Integer> var1, List<String> var2) {

        //将原ArrayList封装为LinkedList链表
        LinkedList<Integer> numList = new LinkedList<>(var1);
        LinkedList<String> strList = new LinkedList<>(var2);
        int numSize = numList.size();
        int strSize = strList.size();

        //定义总List，长度为两个List的合
        int allSize = numSize + strSize;
        ArrayList<Object> allList = new ArrayList<>(allSize);

        //获取并遍历最大的List，防止数据丢失
        int y = 0;
        while (allList.size() < allSize) {
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
            y++;
        }
        System.out.println("共循环次数:" + y);
        return allList;
    }


    private static List<Object> assembleList4(List<Integer> var1, List<String> var2) {

        //将原ArrayList封装为LinkedList链表
        LinkedList<Integer> numList = new LinkedList<>(var1);
        LinkedList<String> strList = new LinkedList<>(var2);
        int numSize = numList.size();
        int strSize = strList.size();

        //定义总List，长度为两个List的合
        int allSize = numSize + strSize;
        ArrayList<Object> allList = new ArrayList<>(allSize);


        //获取并遍历最大的List，防止数据丢失
        int i = 0;
        int y = 0;
        while (i < allSize) {
            //按照顺序组合
            if (!numList.isEmpty()) {

                //从链表头部弹出元素，并添加到总List集合中
                allList.add(numList.poll());
                i++;
            }
            if (!strList.isEmpty()) {
                allList.add(strList.poll());
                i++;
            }
            if (!numList.isEmpty()) {
                allList.add(numList.poll());
                i++;
            }
            y++;
        }
        System.out.println("共循环次数:" + y);
        return allList;
    }
}
