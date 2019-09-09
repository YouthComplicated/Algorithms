package jdk.collection.list;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

public class TestVector {


    static <T> void printLine(T ... args){
        if(args.length > 0){
            System.out.println("===============" + args[0]);
        }else{
            System.out.println("===============");
        }

    }

    /**
     *
     * 初始化方法
     */
    @Test
    public void test01(){
        /**
         * 指定初始化大小并且可以指定自增数量
         */
        Vector<Integer> vector = new Vector<>(2,2);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println(11111);


        Vector<Integer> vector1 = new Vector<>();
        vector1.add(11);
        vector1.add(null);
        System.out.println(vector1.toString());

    }

    /**
     * elements 枚举类的迭代
     */
    @Test
    public void test02(){

        Vector<Integer> vector = new Vector<>(2,2);
        vector.add(1);
        vector.add(2);
        vector.add(3);

        Enumeration<Integer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        /**
         * elementAt() 同步
         */
        System.out.println("====================");
        System.out.println(vector.elementAt(0));
//        System.out.println(vector.elementAt(11));

        /**
         * firstElement() 同步
         */
        System.out.println(vector.firstElement());

        /**
         * lastElement() 同步
         */
        System.out.println(vector.lastElement());



    }


}











