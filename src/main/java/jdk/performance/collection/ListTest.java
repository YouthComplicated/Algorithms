package jdk.performance.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private final  int NUM = 2000;


    /**
     * list优化  使用声明大小，提升速度
     */
    @Test
    public void test01(){

        long start = System.currentTimeMillis();
        List<Integer> listA = new ArrayList<>();
        for(int i = 0; i < NUM; i++){
            //自动装箱的操作
            listA.add(i);
        }
        System.out.println("未声明数组大小耗时：" + (System.currentTimeMillis() - start)+ " ms");

        long start1 = System.currentTimeMillis();
        List<Integer> listB = new ArrayList<>(NUM);
        for(int i = 0; i < NUM; i++){
            //自动装箱的操作
            listB.add(i);
        }
        System.out.println("声明数组大小耗时：" + (System.currentTimeMillis() - start1)+ " ms");

    }

    @Test
    public void test02(){

        long start = System.nanoTime();
        List<Integer> listA = new ArrayList<>();
        for(int i = 0; i < NUM; i++){
            //自动装箱的操作
            listA.add(i);
        }
        long end = System.nanoTime();
        System.out.println("未声明数组大小耗时：" + (end - start)+ " nas");

        long start1 = System.nanoTime();
        List<Integer> listB = new ArrayList<>(NUM);
        for(int i = 0; i < NUM; i++){
            //自动装箱的操v作
            listB.add(i);
        }
        long end1 = System.nanoTime();
        System.out.println("声明数组大小耗时：" + (end1 - start1)+ " nas");


        System.out.println("faster: "+ (end - start - end1 + start1) + " nas");
    }

    @Test
    public void test03(){

        long start = System.nanoTime();
        List<Integer> list = new ArrayList<>(NUM);
        for(int i = 0; i < NUM; i++){
            //自动装箱的操作
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println("使用集合耗时：" + (end - start)+ " nas");


        long start1 = System.nanoTime();
        long [] arr = new long[NUM];
        for(int i = 0; i < NUM; i++){
            //自动装箱的操作
            arr[i] = i;
        }
        long end1 = System.nanoTime();
        System.out.println("声明数组大小耗时：" + (end1 - start1)+ " nas");


        System.out.println("faster: "+ (end - start - end1 + start1) + " nas");
    }


    @Test
    public void test04(){

        List<Integer> listA = new ArrayList<>(3);
        listA.add(1);
        listA.add(2);
        System.out.println(listA.size());

    }
}
