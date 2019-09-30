package jdk.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class CalendarTest {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test01(){

        Calendar calendar = Calendar.getInstance();
        //CalendarTypes
        System.out.println(Calendar.getAvailableCalendarTypes());
        //Locales
        System.out.println(Arrays.toString(Calendar.getAvailableLocales()));
        //TimeZone
        System.out.println(TimeZone.getDefault());

    }

    /**
     * test builder
     *
     * setInstant() long or date
     *
     * set(int field, int value)
     *
     * setFields(int... fieldValuePairs)
     *
     */
    @Test
    public void test02(){
        //Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setWeekDate(2013, 1, MONDAY).build();

        long time = System.currentTimeMillis();
        System.out.println("time:"+time);
        Calendar calendar = new Calendar.Builder().setCalendarType("gregory").setInstant(time).build();
        System.out.println("calendar:"+calendar.getTimeInMillis());
        System.out.println("year:"+calendar.get(Calendar.YEAR));

        Calendar calendar1 = new Calendar.Builder().setCalendarType("japanese").setInstant(time).build();
        System.out.println("calendar1:"+calendar1.getTimeInMillis());
        System.out.println("year:"+calendar1.get(Calendar.YEAR));

        System.out.println("===================");

        /**
         * java.util.GregorianCalendar[time=1546272000000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
         * zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=29,lastRule=null],
         * firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,
         * DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=28800000,DST_OFFSET=0]
         */
        Calendar calendar2 = new Calendar.Builder().set(Calendar.YEAR,2019).build();
        System.out.println(calendar2.toString());
        System.out.println("format2:"+ sdf1.format(calendar2.getTime()));

        Calendar calendar3 = new Calendar.Builder().setFields(Calendar.YEAR,2020,
                Calendar.MONTH,2,Calendar.DAY_OF_MONTH,3,Calendar.HOUR_OF_DAY,13,Calendar.MINUTE,20,Calendar.SECOND,30).build();
        System.out.println("format3:"+ sdf1.format(calendar3.getTime()));


    }

    /**
     *
     * builder
     *
     * setDate(int year, int month, int dayOfMonth)   <==>  setFields()
     *
     * setTimeOfDay(int hourOfDay, int minute, int second)
     *
     * setWeekDefinition(int firstDayOfWeek, int minimalDaysInFirstWeek)  ????
     *
     */
    @Test
    public void test03(){
        Calendar calendar = new Calendar.Builder().setDate(2019,2,28).build();
        System.out.println("format:"+ sdf1.format(calendar.getTime()));

        Calendar calendar1 = new Calendar.Builder().setTimeOfDay(3,2,15).build();
        System.out.println("format1:"+ sdf1.format(calendar1.getTime()));

        Calendar calendar2 = new Calendar.Builder().setDate(2019,2,28)
                .setTimeOfDay(3,2,16).build();
        System.out.println("format2:"+ sdf1.format(calendar2.getTime()));

        //dayOfWeek 周日 1 周一 2 ....
        Calendar calendar3 = new Calendar.Builder().setDate(2019,2,28)
                .setWeekDate(2019,5,1).build();
        System.out.println("format3:"+ sdf1.format(calendar3.getTime()));

        Calendar calendar4 = new Calendar.Builder().setDate(2019,2,28)
                .setWeekDate(2019,1,1).build();
        System.out.println("format4:"+ sdf1.format(calendar4.getTime()));

        Calendar calendar5 = new Calendar.Builder().setDate(2019,2,28)
                .setWeekDefinition(1,3).build();
        System.out.println("format5:"+ sdf1.format(calendar5.getTime()));

    }


    /**
     * test getInstance 涉及到获取TimeZone,Locale默认值
     */
    @Test
    public void test04(){
        /**
         *
         * public Calendar getInstance(TimeZone var1, Locale var2) {
         *    return (new Builder()).setLocale(var2).setTimeZone(var1).setInstant(System.currentTimeMillis()).build();
         *}
         */
        Calendar calendar = Calendar.getInstance();

    }


    /**
     *
     * 通过字段计算时间
     *
     * Date getTime() ==> return new Date(getTimeInMillis());
     *
     */
    @Test
    public void test05(){
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        System.out.println("firstDayOfWeek:"+calendar.getFirstDayOfWeek());
    }

    /**
     *
     * Calendar get(int) 获取相应字段的值
     *
     *    set(int, int)  fieldID:fieldValue
     *    set(int, int, int)  年月日
     *    set(....) 年月日时分
     *    set(....) 年月日时分秒
     *
     *    clear()
     */
    @Test
    public void test06(){
        Calendar calendar = Calendar.getInstance();
        System.out.println("year:"+calendar.get(Calendar.YEAR));
        calendar.set(Calendar.YEAR,2018);
        System.out.println("year_chanage:"+calendar.get(Calendar.YEAR));

        //month:0-11
        calendar.set(2019,11,3);
        System.out.println(sdf1.format(calendar.getTime()));

        calendar.clear();
        System.out.println("clear:"+sdf1.format(calendar.getTime()));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.clear(Calendar.YEAR);
        System.out.println("clear:"+sdf1.format(calendar1.getTime()));


        System.out.println("Year-IsSet:"+calendar1.isSet(Calendar.YEAR));
        System.out.println("MONTH-IsSet:"+calendar1.isSet(Calendar.MONTH));
    }


    /**
     *
     * 
     * getDisplayName()
     *
     * 
      */
    @Test
    public void test07(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getDisplayName(Calendar.MONTH,Calendar.SHORT, Locale.ENGLISH));
        System.out.println(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT, Locale.CHINESE));

        System.out.println(calendar.getDisplayNames(Calendar.MONTH,Calendar.SHORT, Locale.ENGLISH).toString());
        System.out.println(calendar.getDisplayNames(Calendar.MONTH,Calendar.LONG_FORMAT, Locale.ENGLISH).toString());
        System.out.println(calendar.getDisplayNames(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.ENGLISH).toString());

    }

    @Test
    public void test08(){
        
        System.out.println(Calendar.getAvailableCalendarTypes());

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.getCalendarType());
    }


    /**
     * 比较  实际比较时间戳的值
     */
    @Test
    public void test09(){


        //before
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR,2018);
        Calendar calendar2 = Calendar.getInstance();
        System.out.println(calendar1.before(calendar2));


        //after

        //compareTo


    }

    /**
     * Calendar抽象类下的具体实现类:GregorianCalendar
     */
    @Test
    public void test10(){

        //add 对某些字段记性添加操作
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(Calendar.YEAR,1);
        System.out.println(sdf1.format(gregorianCalendar.getTime()));

        /**
         * roll() 不会智能修改其它的字段
         */
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(2019,1,28);
        System.out.println(sdf1.format(calendar.getTime()));
        calendar.roll(Calendar.DATE, 1);
        System.out.println(sdf1.format(calendar.getTime()));


    }


    @Test
    public void test11(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println("min:"+calendar.getMinimalDaysInFirstWeek());
        System.out.println("weekYear:"+calendar.getWeekYear());

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2019,1,28); 
        System.out.println("weeksInWeekYear:"+calendar1.getWeeksInWeekYear());


        System.out.println("year:"+calendar1.getMaximum(Calendar.YEAR));
        System.out.println("month:"+calendar1.getMaximum(Calendar.MONTH));
        System.out.println("year:"+calendar1.getMinimum(Calendar.MONTH));

    }


    /**
     * instant
     */
    @Test
    public void test12(){
        Calendar calendar = Calendar.getInstance();
        Instant instant = calendar.toInstant();
        System.out.println(instant);

    }

    

    @Test
    public void test13(){

        long i = 1L;
        Date date = new Date(i);
        System.out.println(sdf1.format(date));

        long i1 = -1L;
        Date date1 = new Date(i1);
        System.out.println(sdf1.format(date1));

        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(-1L);
        System.out.println("timeMills:"+ calendar.getTimeInMillis());
        System.out.println(sdf1.format(calendar));


    }



}
