package jdk.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
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


    /**
     * LocalDate
     */
    @Test
    public void TestLocalDate(){
        // 1. 获取当前日期(年月日) -----打印输出-----2018-01-29
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        // 2. 根据年月日构建Date ----打印输出-----2018-01-30
        LocalDate localDate1 = LocalDate.of(2018, 01, 30);
//        LocalDate localDate11= LocalDate.of(2018, 01, 3444);
//        System.out.println(localDate11);


        // 3. 字符串转换日期,默认按照yyyy-MM-dd格式，也可以自定义格式 -----打印输出-----2018-01-30
        LocalDate localDate2 = LocalDate.parse("2018-01-30");

        // 4. 获取本月第一天 -----打印输出-----2018-01-01
        LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());


        // 5. 获取本月第二天  -----打印输出-----2018-01-02
        LocalDate secondDayOfMonth = localDate.withDayOfMonth(2);

        // 6. 获取本月最后一天 -----打印输出-----2018-01-31
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());

        // 7. 明天 -----打印输出----- 2018-01-30
        LocalDate tomorrowDay = localDate.plusDays(1L);

        // 8. 昨天 -----打印输出----- 2018-01-28
        LocalDate yesterday = localDate.minusDays(1L);

        // 9. 获取本年第12天 -----打印输出----- 2018-04-30
        LocalDate day = localDate.withDayOfYear(120);

        // 10. 计算两个日期间的天数
        long days = localDate.until(localDate1, ChronoUnit.DAYS);
        System.out.println(days);

        // 11. 计算两个日期间的周数
        long weeks = localDate.until(localDate1, ChronoUnit.WEEKS);
        System.out.println(weeks);

    }


    /**
     * LocalTime
     */
    @Test
    public void TestLocalTime(){
        // 1. 获取当前时间，包含毫秒数 -----打印输出----- 21:03:26.315
        LocalTime localTime = LocalTime.now();

        // 2. 构建时间 -----打印输出----- 12:15:30
        LocalTime localTime1 = LocalTime.of(12, 15, 30);

        // 3. 获取当前时间，不包含毫秒数 -----打印输出----- 21:01:56
        LocalTime localTime2 = localTime.withNano(0);

        // 4. 字符串转为时间，还可以有其他格式，比如12:15, 12:15:23.233
        // -----打印输出----- 12:15:30
        LocalTime localTime3 = LocalTime.parse("12:15:30");
    }


    @Test
    public void TestLocalDateTime(){

        // 1. 获取当前年月日 时分秒 -----打印输出----- 2018-01-29T21:23:26.774
        LocalDateTime localDateTime = LocalDateTime.now();

        // 2. 通过LocalDate和LocalTime构建 ----- 打印输出----- 2018-01-29T21:24:41.738
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        // 3. 构建年月日 时分秒 -----打印输出----- 2018-01-29T19:23:13
        LocalDateTime localDateTime2 = LocalDateTime.of(2018, 01, 29, 19, 23, 13);

        // 4. 格式化当前时间 ----打印输出----- 2018/01/29
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(formatter.format(localDateTime2));

    }

    @Test
    public void TestTemporalAdjusters(){
        LocalDate localDate = LocalDate.now();

        // 1. 本月第一天
        LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());

        // 2. 本月最后一天
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());

        // 3. 本年第一天
        LocalDate firstDayOfYear = localDate.with(TemporalAdjusters.firstDayOfYear());

        // 4. 下个月第一天
        LocalDate firstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());

        // 5. 本年度最后一天
        LocalDate lastDayOfYear = localDate.with(TemporalAdjusters.lastDayOfYear());

        System.out.println(firstDayOfMonth);
        System.out.println(lastDayOfMonth);
        System.out.println(firstDayOfYear);
        System.out.println(firstDayOfNextMonth);
        System.out.println(lastDayOfYear);
    }

    /**
     * Period和Duration
     * Period是基于ISO-8601标准的日期系统，用于计算两个日期间的年，月，日的差值。比如'2年，3个月，4天'；
     * 而Duration和Period很像，但Duration计算的是两个日期间的秒，纳秒的值，是一种更为精确的计算方式；
     * 而ISO-8601系统是当今世界大部分地区采用的现代日历的阳历系统。
     *
     */
    public void TestPeriodAndDuriation(){

    }

}
