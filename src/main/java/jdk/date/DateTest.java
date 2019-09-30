package jdk.date;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTest {


    @Test
    public void test001(){
        /**
         * public static native long currentTimeMillis();
         */
        long i = System.currentTimeMillis();
        System.out.println("时间戳："+i);

        Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(i);
        System.out.println(date1);

        /**
         * 过时
         */
        Date date2 = new Date(2019,1,2,3,1,1);
        System.out.println(date2);


    }


    @Test
    public void testCalendar(){
        /**
         *
         * initialized with the current date and time
         */
        Calendar calendar = Calendar.getInstance();
        /**
         * calendar.getxxx()
         */
        calendar.getTimeInMillis();
        calendar.getTime();
        calendar.roll(11,false);
    }

    @Test
    public void testCalendar1(){
        //抽象类重写相应的方法
        //Calendar calendar = new Calendar();

        Calendar calendar = new Calendar.Builder().build();
        System.out.println(calendar.getTimeInMillis());

    }





    @Test
    public void testLocale(){

        Locale locale = Locale.getDefault();
        System.out.println("locale:" + locale);

        System.out.println("china:" + Locale.SIMPLIFIED_CHINESE);

    }


    @Test
    public void test01(){
        Date date = new Date();
        LocalDateTime time1  = LocalDateTime.now();
        LocalDateTime time2  = LocalDateTime.now();
    }

    @Test
    public void test02(){
        long a = 1000_000L;
        System.out.println(a);
    }

    /**
     * duration
     */
    @Test
    public void test03(){
        Duration duration = Duration.ofHours(1);
        System.out.println(duration);
        //0
        System.out.println(duration.getNano());
        System.out.println(duration.getSeconds());
    }


    /**
     * TemporalAdjusters
     */
    @Test
    public void test04(){

        TemporalAdjuster adjusters = TemporalAdjusters.firstDayOfMonth();


    }



}
