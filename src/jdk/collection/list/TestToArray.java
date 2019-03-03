package jdk.collection.list;

import org.junit.Test;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestToArray {

    /**
     * arrrayList 拥有自己的toArray()方法 没有利用abstractionCollection中toArray()
     * @param args
     */
    public static void main(String[] args) {

//        Collection con1 = new ArrayList();
//        con1.add(1);
//        con1.add(5);
//        con1.add(8);
//        System.out.println(con1.toArray());


//        AbstractCollection abstractCollection = new ArrayList();
//        abstractCollection.add(1);
//        abstractCollection.add(2);
//        System.out.println(abstractCollection.toArray());


//        List con1 = new ArrayList();
//        con1.add(1);
//        con1.add(5);
//        con1.add(8);
//        System.out.println(con1.toArray());  // 进入arrayList 中toArray() 方法

//        ArrayList con1 = new ArrayList();
//        con1.add(1);
//        con1.add(5);
//        con1.add(8);
//        System.out.println(con1.toArray()); // 进入arrayList 中toArray() 方法
    }

    @Test
    public void test01(){
        Collection con1 = new ArrayList();
        con1.add(1);
        con1.add(5);
        con1.add(8);
        System.out.println(con1.toArray());
    }

    public void test02(){

    }


}
