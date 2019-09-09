package jdk.date;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTest {




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
