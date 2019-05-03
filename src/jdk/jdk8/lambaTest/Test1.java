package jdk.jdk8.lambaTest;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 迭代方式
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // method reference
        list.forEach(System.out::println);
    }


    /**
     * 普通迭代(基于数组index)
     */
    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        for(int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }


    /**
     * for循环迭代
     */
    @Test
    public void test02(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        for(Integer i : list) {
            System.out.println(i);
        }
    }


    /**
     * 内部迭代 各种版本变种
     */
    @Test
    public void test03(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        list.forEach(new Consumer<Integer>() {
            public void accept(Integer value) { System.out.println(value);
        } });

        list.forEach((Integer value) -> System.out.println(value));

        list.forEach(value -> System.out.println(value));

        list.forEach(System.out::println);

    }



    @Test
    public void test04(){

    }








}
