package jdk.date;

import org.junit.Test;

import java.util.Date;

public class DateTest01 {



    @Test
    public void test01(){

        Date date = new Date();
        System.out.println(date);

        /**
         *
         * 克隆两个最重要属性
         *
         * private transient long fastTime;
         *
         * private transient BaseCalendar.Date cdate;
         *
         *
         */
        Date clone = (Date)date.clone();
        System.out.println(clone);


        long time = System.currentTimeMillis();

        Date date1 = new Date(time);
        Date date2 = new Date();
        /**
         * 决定使用fastTime属性，将cdate置为null
         */
        date2.setTime(time);

    }


    @Test
    public void test02(){

        Date date = new Date();
        System.out.println(date.toString());

        System.out.println(date.toLocaleString());


    }





}
