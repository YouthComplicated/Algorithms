package jdk.date.newDate;

import org.junit.Test;

import java.time.LocalTime;

public class LocalTimeTest {


    /**
     *
     * LocalTime
     *
     * 实例的创建：
     *
     * now() of() ofXXX()
     *
     *
     */
    @Test
    public void Test01(){

        LocalTime localTime1 = LocalTime.now();
        System.out.println("localTime1:" + localTime1);

        LocalTime localTime2 = LocalTime.of(23, 15, 10);
        System.out.println("localTime2:" + localTime2);

        LocalTime localTime3 = LocalTime.of(23, 2, 4, 1000);
        System.out.println("localTime3:" + localTime3);

        LocalTime localTime = LocalTime.ofNanoOfDay(1);
        System.out.println("localTime:" + localTime);

        LocalTime localTime4 = LocalTime.ofSecondOfDay(1);
        System.out.println("localTime4:" + localTime4);

    }


    /**
     *
     */
    @Test
    public void test02(){

    }



}
