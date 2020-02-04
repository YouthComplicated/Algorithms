package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 多线程并行处理定时任务时，Timer运行多个TimeTask时，只要其中之一没有捕获抛出的异常，其它任务便会自动终止运行，使用ScheduledExecutorService则没有这个问题。
 *      //org.apache.commons.lang3.concurrent.BasicThreadFactory
 *      ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
 *      new BasicThreadFactory.Builder().namingPattern("example-schedule-thread.pool-%d").daemon(true).build());
 *      executorService.scheduleAtFixedRate(new Runnable() {
 *       @Override
 *      public void run() {
 *      //do something
 *      }
 *      },initialDelay,period, TimeUnit.HOURS);
 */
public class TimeTask {

    public static void main(String[] args) {
        Timer timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("===timertask start run======");
            }
       }, 0,1000);
    }
}
