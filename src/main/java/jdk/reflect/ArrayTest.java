package jdk.reflect;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * java.lang.reflect.Array
 *
 * The {@code Array} class provides static methods to dynamically create and access Java arrays
 *
 */
public class ArrayTest {


    /**
     * 数组
     */
    @Test
    public void test01() throws ClassNotFoundException {

        /**
         * 动态创建数组
         */
        int[] array = (int [] )Array.newInstance(int.class, 3);
        System.out.println(array);
        System.out.println(Arrays.toString(array));

        Array.set(array, 0,11);
        System.out.println(Arrays.toString(array));

        //argument type mismatch
//        Array.set(array, 1, "wwww");
//        System.out.println(Arrays.toString(array));


        Class stringArray = String[].class;
        System.out.println(stringArray);

        Class intArray = Class.forName("[I");
        System.out.println(intArray);


        //通过反射获取数组的class对象
        /**
         * 你不能通过Class.forName()方法获取一个原生数据类型的Class对象。
         * 下面这两个例子都会报ClassNotFoundException
         */
//        Class intClass1 = Class.forName("I");
//        Class intClass2 = Class.forName("int");


        String className = null;

        if("int" .equals(className)){

        }
        if("long".equals(className)){

        }

        Class stringArrayClass = Array.newInstance(String.class, 0).getClass();
        System.out.println("is array: " + stringArrayClass.isArray());

        /**
         * 一个数组的Class对象，你就可以通过Class.getComponentType()方法获取这个数组的成员类型。
         */

        String[] strings = new String[3];
        Class aClass = strings.getClass();
        Class stringArrayComponentType = aClass.getComponentType();
        System.out.println(stringArrayComponentType);
    }
}
