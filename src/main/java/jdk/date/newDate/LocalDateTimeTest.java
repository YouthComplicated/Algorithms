package jdk.date.newDate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {

    /**
     * 初始化 now of
     */
    @Test
    public void test01(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:" + localDateTime);

        LocalDate localDate = LocalDate.of(2019, 8, 20);
        System.out.println("localDate:" + localDate);

        LocalTime localTime = LocalTime.of(12, 23, 0, 11);
        System.out.println("localTime:"+localTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime1:" + localDateTime1);

    }




}
