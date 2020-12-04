package jdk.collection.list;

import org.junit.Test;

import java.util.*;


/**
 * 以下方法都是进入到ArrayList的toArray(); 方法中
 *
 * 向上转型+方法的动态绑定
 */
public class TestToArray {

    /**
     * arrrayList 拥有自己的toArray()方法 没有利用abstractionCollection中toArray()
     *
     *
     */
    @Test
    public void test01(){
        Collection con1 = new ArrayList();
        con1.add(1);
        con1.add(5);
        con1.add(8);
        Object[] objects = con1.toArray();
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void test02(){
        AbstractCollection abstractCollection = new ArrayList();
        abstractCollection.add(1);
        abstractCollection.add(2);
        /**
         * 不要被编译器迷惑，实际进入到实际对象类型的方法中
         */
        Object[] objects = abstractCollection.toArray();
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void test03(){
        List con1 = new ArrayList();
        con1.add(1);
        con1.add(5);
        con1.add(8);
        Object[] objects = con1.toArray();
        // 进入arrayList 中toArray() 方法
        System.out.println(Arrays.toString(objects));
    }


}
