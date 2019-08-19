package jdk.collection.list;

import org.junit.Test;

import java.util.*;

public class ArrayListPerformance {


    private static final int SIZE = 100_000;

    /**
     * 有关ArrayList性能相关问题
     *
     * 1、重置一个ArrayList--clear vs removeAll
     * 列表很大(eg:10M个元素)，那么选择clear还是removeAll会对你java应用的性能造成巨大的影响。甚至有时，
     * 在列表过大的情况下，重置会耗费许多时间，那么重新创建一个新的列表比将老的列表重置要好。但需要提醒的是，
     * 必须要确保老的列表可以被垃圾回收，否则，有很大的风险会出现java.lang.OutOfMemoryError: Java Heap Space
     *
     */
    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(3,4,1,2,3);
        List<Integer> list2 = Arrays.asList(4,3);
        list.addAll(list1);
        list.removeAll(list2);
        System.out.println(list);



        // Two ArrayList for clear and removeAll
        ArrayList numbers = new ArrayList(SIZE);
        ArrayList integers = new ArrayList(SIZE);
        // Initialize ArrayList with 10M integers
        for (int i = 0; i < SIZE; i++) {
            numbers.add(new Integer(i));
            integers.add(new Integer(i));
        }
        // Empty ArrayList using clear method
        long startTime = System.nanoTime();
        numbers.clear();
        long elapsed = System.nanoTime() - startTime;
        System.out.println("Time taken by clear to empty ArrayList of 1M elements (ns): " + elapsed);
        // Reset ArrayList using removeAll method
        startTime = System.nanoTime();
        integers.removeAll(integers);
        long time = System.nanoTime() - startTime;
        System.out.println("Time taken by removeAll to reset ArrayList of 1M elements (ns): " + time);


    }


    /**
     *
     * 为什么arrayList.removeAll(set)的速度远高于arrayList.removeAll(list)？
     *
     *
     * HashSet.contains() vs ArrayList.contains()
     *
     * ArrayList.contains():indexOf() 最坏时间复杂度为O(总数据量)。
     *
     * HashSet.contains():HashSet的底层是HashMap,实际也就是调用map.containKey()方法。
     *
     *
     * 同时也知道了，在数据量比较大的的情况下，使用arrayList.removeAll(subList)时，可以更改为：
     * 将subList封装为HashSet：arrayList.removeAll(new HashSet(subList))
     * 将arrayList改为LinkedList：new LinkedList(arrayList).removeAll(subList)
     */
    @Test
    public void test02(){

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(2);

        List list0 = new ArrayList();
        list0.add(set);
        System.out.println("set:"+list0.toString());

        List list1 = new ArrayList();
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        List<Integer> list3 = Arrays.asList(3,4);
        list1.addAll(list2);
        list1.addAll(list3);
        System.out.println("list1:"+list1.toString());
        Set<Integer> set1 = new HashSet(list1);
        System.out.println("set1:"+set1.toString());





    }
















}
