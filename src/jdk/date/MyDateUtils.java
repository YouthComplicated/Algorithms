package jdk.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {

//    private MyDateUtils(){
//        //never instant
//    }

    /**
     * LocalDateTime 使用
     */
    @Test
    public void test01(){

        /**
         * 获取当前时间的毫秒数
         */
        long time1 = System.currentTimeMillis();//fast
        long time2 = new Date().getTime();
        long time3 = Calendar.getInstance().getTimeInMillis();
        /**
         * timestamp(long)<-->LocalDateTime
         */
        Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());


        //字符串转换
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        //LocalDateTime<-->Date
        Date date = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
        System.out.println("LocalDateTime-time:"+df.format(time));
        System.out.println("Date:"+ sdf.format(date));
        System.out.println("LocalDateTime-dateTime:"+df.format(dateTime));


        //LocalDateTime<-->LocalDate
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date1 = Date.from(instant);


        LocalDateTime ldt = LocalDateTime.parse("2018-06-01 10:12:05",df);


        //当天的0点
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);


    }

    public static void main(String[] args) {
        //年月日
        LocalDate localDate = LocalDate.of(2018,3,5);
        System.out.println(localDate);
        //时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

}
