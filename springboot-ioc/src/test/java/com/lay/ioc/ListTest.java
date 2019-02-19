package com.lay.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:37 2019/2/19
 * @Modified By:IntelliJ IDEA
 */
public class ListTest {

    public static void main(String[] args){
        List<String> arrays=new ArrayList();
        initList(arrays);
        ArrayList<String> arrays2 = new ArrayList<>(arrays);
        List<String> clone = (ArrayList)arrays2.clone();
        test3(arrays2);
        printList(arrays2);
    }
    public static void initList(List<String> arrays){
        arrays.add("小A");
        arrays.add("小B");
        arrays.add("小C");
        arrays.add("小D");
        arrays.add("小E");
        arrays.add("小F");
    }

    public static void test1(List<String> arrays){
        for(int i=0;i<arrays.size();i++){
            String array= arrays.get(i);
            if(array.equals("小C")){
                arrays.remove(array);
            }
        }
    }

    public static void test2(List<String> arrays){
        for (String array : arrays) {
            if(array.equals("小C")){
                arrays.remove("小C");
                break;
            }
        }
    }

    public static void test3(List<String> arrays){
        Iterator<String> iterator = arrays.iterator();
        while (iterator.hasNext()){
            String array=iterator.next();
            if(array.equals("小C")){
                iterator.remove();
            }
        }
    }


    public static void printList(List<String> arrays){
        arrays.stream().forEach(System.out::println);
    }
}
