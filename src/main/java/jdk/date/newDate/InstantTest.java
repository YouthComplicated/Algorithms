package jdk.date.newDate;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.junit.Test;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class InstantTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test01(){

        /**
         * instant 初始化 now() now(clock) ofEpochXX();
         */
        Instant instant = Instant.now();
        System.out.println("seconds:"+instant.getEpochSecond());
        System.out.println("millis:"+instant.toEpochMilli());

        /**
         * clock
         */
        Clock clock = Clock.systemUTC();
        Instant instant1 = Instant.now(clock);
        System.out.println("instant:" + instant1);


        Instant instant2 = Instant.ofEpochMilli(1);
        Instant instant3 = Instant.ofEpochSecond(2);
        Instant instant4 = Instant.ofEpochSecond(1,2);


        System.out.println(instant2.getEpochSecond());
        System.out.println(instant3.getEpochSecond());
        System.out.println(instant4.getEpochSecond());


    }


    /**
     *  from()  atOffset()  atZone() isAfter() isBefore()
     */
    @Test
    public void test02(){

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toString());
        System.out.println(dateTime);


        /**
         * 报错：
         * java.time.DateTimeException: Unable to obtain Instant from TemporalAccessor:
         * 2019-09-27T11:51:03.892 of type java.time.LocalDateTime
         */
//        Instant instant = Instant.from(dateTime);
//        System.out.println(instant);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime:"+ zonedDateTime);

        Instant instant1 = Instant.from(zonedDateTime);
        System.out.println("instant from zonedDateTime:"+ instant1);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("OffsetDateTime:" + offsetDateTime);
        Instant instant2 = Instant.from(offsetDateTime);
        System.out.println("instant from OffsetDateTime" + instant2);


        Instant instant0 = Instant.now();

        System.out.println("second:" + instant0.getEpochSecond());

        Instant instant3 = instant0.truncatedTo(ChronoUnit.SECONDS);

        System.out.println("second:" + instant3.getEpochSecond());


    }

    /**
     *
     * truncatedTo() 截断单位
     *
     * 涉及到年月日时间单位的，从instant中获取不到，会抛出java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: XXX
     *
     * System.out.println(FORMATTER.format(instant));
     *
     */
    @Test
    public void test03(){

        Instant instant = Instant.now();
        /**
         * java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: YearOfEra
         */
        //System.out.println(FORMATTER.format(instant));

        System.out.println("seconds:" + instant.getEpochSecond());
        System.out.println("millis:" + instant.getNano());
//        Instant instant1 = instant.truncatedTo(ChronoUnit.MINUTES);
//        Instant instant1 = instant.truncatedTo(ChronoUnit.SECONDS);
        Instant instant1 = instant.truncatedTo(ChronoUnit.MILLIS);
        System.out.println("seconds:" + instant1.getEpochSecond());
        System.out.println("millis:"+ instant1.getNano());


    }

    /**
     * atOffset()
     */
    @Test
    public void test04(){

        Instant instant = Instant.now();
        System.out.println(instant.toString());
        System.out.println(ZoneId.getAvailableZoneIds());

//        ZoneOffset zoneOffset = ZoneOffset.of("Asia/Shanghai");
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        System.out.println(zoneOffset.toString());
        OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
        System.out.println("offsetDateTime:" + offsetDateTime);


    }

    /**
     * atZone()
     */
    @Test
    public void test05(){
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

    }

    /**
     * isAfter() isBefore()
     */
    @Test
    public void test06() throws InterruptedException {

        Instant before = Instant.now();
        Thread.sleep(1000);
        Instant after = Instant.now();
        System.out.println("before:" + before.toEpochMilli());
        System.out.println("after: "+ after.toEpochMilli());
        System.out.println("isBefore:" + before.isBefore(after));
        System.out.println("isAfter:" + before.isAfter(after));

    }



}
