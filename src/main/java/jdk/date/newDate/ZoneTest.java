package jdk.date.newDate;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;

public class ZoneTest {


    /**
     * ZoneId
     */
    @Test
    public void test01(){

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId.toString());
        System.out.println(ZoneId.getAvailableZoneIds());

    }

    /**
     * ZoneOffset
     */
    @Test
    public void test02(){
        // parse - +h, +hh, +hhmm, +hh:mm, +hhmmss, +hh:mm:ss
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        System.out.println(zoneOffset.toString());


        ZoneOffset zoneOffset1 = ZoneOffset.ofHours(3);
        System.out.println("zoneOffset1:" + zoneOffset1);


        ZoneOffset zoneOffset2 = ZoneOffset.ofHoursMinutes(2, 10);
        System.out.println("zoneOffset2:" + zoneOffset2);


        ZoneOffset zoneOffset3 = ZoneOffset.ofTotalSeconds(1000);
        System.out.println("zoneOffset3:" + zoneOffset3);

    }
}
