package jdk.date.newDate;

import org.junit.Test;

import java.time.*;

public class LocalDateTest {


    /**
     *
     * 初始化实例
     *
     * now() ...
     *
     * of() ...
     *
     *
     */
    @Test
    public void test01(){

        LocalDate localDate1 = LocalDate.now();
        System.out.println("localDate1:" + localDate1);

        Clock clock = Clock.systemUTC();
        LocalDate localDate2 = LocalDate.now(clock);
        System.out.println("localDate2:" + localDate2);

        LocalDate localDate3 = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("localDate3:" + localDate3);

        LocalDate localDate4 = LocalDate.of(2019, 2, 23);
        System.out.println("localDate4:" + localDate4);

        LocalDate localDate5 = LocalDate.of(2019, Month.JANUARY,10);
        System.out.println("localDate5:" + localDate5);

        LocalDate localDate6 = LocalDate.ofYearDay(2019,40);
        System.out.println("localDate6:" + localDate6);

        LocalDate localDate7 = LocalDate.ofEpochDay(5);
        System.out.println("locateDate7:"+localDate7);
    }

    /**
     *  with()
     */
    @Test
    public void test02(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 =  localDate.withYear(2018);
        System.out.println("localDate1:" + localDate1+" localDate:" + localDate);

    }

    /**
     *  plus()  minus()
     */
    @Test
    public void test03(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusYears(1);
        System.out.println("localDate1:" + localDate1);

        LocalDate localDate2 = localDate1.minusMonths(2);
        System.out.println("localDate2:" + localDate2);

    }

    /**
     *
     * LocalDate <<==>> LocalDateTime
     *
     */
    @Test
    public void test04(){

        LocalDate localDate = LocalDate.of(2018,10,11);
        LocalDateTime localDateTime = localDate.atTime(3, 35);
        System.out.println("localDateTime:" + localDateTime);

        LocalTime localTime = LocalTime.of(5,5,5);
        LocalDateTime localDateTime1 = localDate.atTime(localTime);
        System.out.println("localTime:" + localTime);
        System.out.println("localDateTime1:" + localDateTime1);

        /**
         * 格式化到当天的凌晨  00:00
         */
        LocalDateTime localDateTime2 = localDate.atStartOfDay();
        System.out.println("localDateTime2:" + localDateTime2);

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of("+8"));
        System.out.println("zoneDateTime:" + zonedDateTime);

    }

    /**
     * isBefore()  isAfter()
     */
    @Test
    public void test05(){

        LocalDate localDate = LocalDate.of(2019, 9, 10);
        System.out.println("localDate:" + localDate);
        LocalDate localDate1 = LocalDate.of(2019, 9, 12);
        System.out.println("isBefore:" + localDate.isBefore(localDate1));
        System.out.println("isAfter:" + localDate.isAfter(localDate1));

    }







}
