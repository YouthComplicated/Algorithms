package jdk.performance.box;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 拆装性性能分析
 */
public class TestBox {

    private static long getCounterResult(long length) {
        Long sum = 0L;
        for (int i = 0; i < length; i++) {
            sum += i;
        }
        return sum;
    }

    private static long getCounterResultOp(long length) {
        long sum = 0L;
        for (int i = 0; i < length; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 自动拆装箱面试题
     */
    @Test
    public void test01(){
        // ⓵
        Integer a = new Integer(121);
        Integer b = new Integer(121);
        System.out.println(a == b);

        // ⓶
        Integer c = 121;
        Integer d = 121;
        System.out.println(c == d);

        // ⓷
        Integer e = 129;
        Integer f = 129;
        System.out.println(e == f);

        // ⓸
        int g = 50;
        Integer h = new Integer(50);
        System.out.println(g == h);

        Integer ii = 88;
        Integer.valueOf(88);
    }

    @Test
    public void test02(){
        long startCountTime = System.currentTimeMillis();
        long result = getCounterResult(Integer.MAX_VALUE);
        long endCountTime = System.currentTimeMillis();
        System.out.println("result = " + result + ", and take up time : " + (endCountTime - startCountTime) / 1000 + "s");
    }


    @Test
    public void test03(){
        long startCountTime = System.currentTimeMillis();
        long result = getCounterResultOp(Integer.MAX_VALUE);
        long endCountTime = System.currentTimeMillis();
        System.out.println("result = " + result + ", and take up time : " + (endCountTime - startCountTime) / 1000 + "s");
    }


    @Test
    public void test04(){

        long startCountTime = System.nanoTime();
        long result = getCounterResult(1000);
        long endCountTime = System.nanoTime();

        System.out.println("result = " + result + ", and take up time : " + (endCountTime - startCountTime) + " nas");

        long startCountTime1 = System.nanoTime();
        long result1 = getCounterResultOp(1000);
        long endCountTime1 = System.nanoTime();
        System.out.println("resultop = " + result1 + ", and take up time : " + (endCountTime1 - startCountTime1) + " nas");


        System.out.println("faster = " + (endCountTime - startCountTime-endCountTime1 + startCountTime1) + " nas");


    }


    /**
     * num = 1000    0ms
     *     = 10000   1ms
     *     = 100000  5~7ms
     */
    @Test
    public void test05(){

        long startCountTime = System.currentTimeMillis();
        long result = getCounterResult(1000);
        long endCountTime = System.currentTimeMillis();

        System.out.println("result = " + result + ", and take up time : " + (endCountTime - startCountTime) + " ms");

        long startCountTime1 = System.currentTimeMillis();
        long result1 = getCounterResultOp(1000);
        long endCountTime1 = System.currentTimeMillis();
        System.out.println("resultop = " + result1 + ", and take up time : " + (endCountTime1 - startCountTime1) + " ms");

        System.out.println("faster = " + (endCountTime - startCountTime-endCountTime1 + startCountTime1) + " ms");

    }

    /**
     *  比较大小
     * 1.int和int之间，用==比较，肯定为true。基本数据类型没有equals方法
     *
     * 2.int和Integer比较，Integer会自动拆箱，== 和 equals都肯定为true
     *
     * 3.int和new Integer比较，Integer会自动拆箱，调用intValue方法, 所以 == 和 equals都肯定为true
     *
     * 4.Integer和Integer比较的时候，由于直接赋值的话会进行自动的装箱。所以当值在[-128,127]中的时候，由于值缓存在IntegerCache中，
     * 那么当赋值在这个区间的时候，不会创建新的Integer对象，而是直接从缓存中获取已经创建好的Integer对象。而当大于这个区间的时候，会直接new Integer。
     *
     * 当Integer和Integer进行==比较的时候，在[-128,127]区间的时候，为true。不在这个区间，则为false
     *
     * 6.当Integer和Integer进行equals比较的时候，由于Integer的equals方法进行了重写，比较的是内容，所以为true
     *
     * 7.Integer和new Integer : new Integer会创建对象，存储在堆中。而Integer在[-128,127]中，从缓存中取，否则会new Integer.
     * 所以 Integer和new Integer 进行==比较的话，肯定为false ; Integer和new Integer 进行equals比较的话，肯定为true
     * new Integer和new Integer进行==比较的时候，肯定为false ; 进行equals比较的时候，肯定为true
     *
     * 原因是new的时候，会在堆中创建对象，分配的地址不同，==比较的是内存地址，所以肯定不同
     * 装箱过程是通过调用包装器的valueOf方法实现的
     * 拆箱过程是通过调用包装器的xxxValue方法实现的（xxx表示对应的基本数据类型）
     *
     *
     */
    @Test
    public void test06(){
        Integer i = new Integer(100);
        Integer j = new Integer(101);
        System.out.println(i == j);
        System.out.println(i > j);
        System.out.println(i < j);
        System.out.println("===========11");

        int k = 100, h = 101;
        System.out.println(i == k);
        System.out.println(i > h);
        System.out.println(i < h);

        System.out.println("===========22");
        Long l1 = 100L;
        Long l2 = 100L;
        Long l3 = 101L;
        System.out.println(l1 == l2);
        System.out.println(l1 > l3);
        System.out.println(l1 < l3);

        System.out.println("===========33");
        Long w1 = new Long(100L);
        Long w2 = new Long(100L);
        Long w3 = new Long(101L);
        System.out.println(w1 == w2);
        System.out.println(w1 > w3);
        System.out.println(w1 < w3);

    }







}
