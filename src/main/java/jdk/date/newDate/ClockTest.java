package jdk.date.newDate;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ClockTest {


    @Test
    public void test01(){
        /**
         *
         * 类中 定义static final class 作用
         * 内部定义4个内部类继承Clock
         *
         *
         * Clock clock = new Clock.SystemClock();编译不通过，修饰符不是public
         *
         *
         * get instances
         *
         *
         */
        Clock clock = Clock.systemUTC();
        System.out.println("clock:"+clock.toString());
        System.out.println("zoneId:"+clock.getZone());

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        Clock clock1 = Clock.system(zoneId);
        Instant instant = clock1.instant();
        System.out.println("instant:"+instant);
        long millis = clock1.millis();
        System.out.println("millis:"+millis);

        Clock clock2 = Clock.systemDefaultZone();


    }
}
