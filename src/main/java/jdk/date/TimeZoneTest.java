package jdk.date;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneTest {


    /**
     * TimeZone
     */
    @Test
    public void testTimeZone(){
        /**
         * TimeZone
         */
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        System.out.println(timeZone);

        TimeZone tz = TimeZone.getDefault();
        System.out.println("default:" + tz);
        System.out.println("defaultZoneId:"+ tz.getID());
        System.out.println("==========");
        System.out.println("AvailableIds:" + Arrays.toString(TimeZone.getAvailableIDs()));
        /**
         * 可以自定义ZoneId
         *
         * CustomID:
         *          GMT Sign Hours : Minutes
         *          GMT Sign Hours Minutes
         *          GMT Sign Hours
         *  Sign: one of
         *          + -
         *  Hours:
         *          Digit
         *          Digit Digit
         *  Minutes:
         *          Digit Digit
         *  Digit: one of
         *          0 1 2 3 4 5 6 7 8 9
         */
        TimeZone tz1 = TimeZone.getTimeZone("Africa/Maputo");
        System.out.println("tz1:" + tz1+"ZoneId:" + tz1.getID());

    }


    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("java.home"));
        String str = System.getProperty("java.home");


    }







}
