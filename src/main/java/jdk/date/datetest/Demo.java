package jdk.date.datetest;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NJ
 * @date 2019/2/16 14:36
 */
public class Demo {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = (List<Integer>) map.get("aa");
        System.out.println((List<Integer>)null);

        Map<String, Object> paramMap = null;
        System.out.println(paramMap.get("bbb"));
    }

    @Test
    public void testTimeStamp(){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);
    }

    @Test
    public void test01(){

        //2019-11-07 21:01:45.055
        long t  = 1573131705055990L;
        Instant instant = Instant.ofEpochMilli(Math.floorDiv(t,1000));
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println(dateTimeFormatter.format(localDateTime));


    }

}
