package com.example.demo.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 20:46 2019/6/6
 * @Modified By:IntelliJ IDEA
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> numList = prepareNumList();
        List<String> letterList = prepareLetterList();

        LinkedList<Integer> integers = new LinkedList<>(numList);
        LinkedList<String> strings = new LinkedList<>(letterList);

        int allSize = integers.size() + strings.size();

        ArrayList<Object> allList = new ArrayList<>(allSize);

        while (allList.size() < allSize) {

            if (integers.size() > 0) {
                allList.add(integers.poll());
            }
            if (strings.size() > 0) {
                allList.add(strings.poll());
            }
            if (integers.size() > 0) {
                allList.add(integers.poll());
            }
        }


        for (Object o : allList) {
            System.out.println(o);
        }


    }


    private static List<Integer> prepareNumList() {
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        return Arrays.asList(numArr);
    }

    private static List<String> prepareLetterList() {
        String[] letterArr = {"A", "B", "C"};
        return Arrays.asList(letterArr);
    }


}
