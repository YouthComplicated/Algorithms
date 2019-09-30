package jdk.date.newDate;

import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DurationTest {



    @Test
    public void test01(){
        /**
         * ofXXX
         */
        Duration duration = Duration.ofHours(2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getUnits());

        Duration duration1 = Duration.of(3, ChronoUnit.SECONDS);
        System.out.println("seconds:"+duration1.getSeconds());

    }


    /**
     * with  plus  minus
     */
    @Test
    public void test02(){
        Duration duration = Duration.ofSeconds(10, 20);
        Duration copyDuration = duration.withSeconds(40);
        System.out.println("seconds:"+copyDuration.getSeconds());
        System.out.println("nano:"+copyDuration.getNano());

        Duration duration1 = Duration.ofSeconds(0,0).plusHours(1);
        System.out.println("duration-seconds:"+duration1.getSeconds());

        /**
         *
         */
        Duration duration2 = Duration.ofSeconds(0,0).plusNanos(Long.MAX_VALUE);
        System.out.println("second2:"+ duration2.getSeconds()+",nano2:" + duration2.getNano());

        Duration duration3 = Duration.ofSeconds(0,0).minusSeconds(10);
        System.out.println(duration3);
        System.out.println("second3:"+ duration3.getSeconds()+", nano3:" + duration3.getNano());

        Duration duration4 = Duration.ofSeconds(0,0).plusMillis(1000);
        System.out.println("second4:"+duration4.getSeconds()+", nano4:"+ duration4.getNano());

    }

}

