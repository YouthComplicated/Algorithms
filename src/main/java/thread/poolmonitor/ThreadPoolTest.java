package thread.poolmonitor;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 *
 * 线程池创建
 *
 *
 * @author: nj
 * @date: 2020-04-05 14:57
 * @version: 0.0.1
 */
public class ThreadPoolTest {


    /**
     *
     * 申请线程池
     * 应用名称 + 线程池名称
     *
     * 应用+线程列表
     *
     * 动态调整参数(7大参数) ==>
     *
     * 机器性能一览
     *
     * cpu 内存  线程数
     *
     * mysql 表结构设计[业务具体的线程]
     *
     * 获取线程池(应用+线程池名称)-- 唯一
     *
     *----管理平台----
     *
     * 核心数
     * 最大值
     * 队列类型
     * 队列长度
     * 是否告警
     * 容量告警
     * 活跃度告警
     *
     *
     * 其它指标展示：
     *
     * 线程池活跃度 = activeCount/maximumPoolSize。
     *
     *
     * 业务开发申请了一个线程池同时用于执行两种任务，一个是发消息任务、一个是发短信任务，这两类任务实际执行的频率和时长对于用户来说没有一个直观的感受，
     * 很可能这两类任务不适合共享一个线程池，但是由于用户无法感知，因此也无从优化。动态化线程池内部实现了任务级别的埋点，
     * 且允许为不同的业务任务指定具有业务含义的名称，线程池内部基于这个名称做Transaction打点，基于这个功能，用户可以看到线程池内部任务级别的执行情况，
     * 且区分业务，任务监控示意图如下图所示：
     *
     * 细粒度控制
     *
     * 秒级告警
     *
     *
     */

    static ExecutorService executorService1 = new ThreadPoolExecutor(4,5,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    static Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);


    public static void main(String[] args) {


//        testNestLoopThread();


        logger.info("xxxxx");

        testCustomPoolExecutor();



    }



    public static void testRefelctSetExecutor(){

//        BeanUtils.getProperty("")


//        this.corePoolSize = corePoolSize;
//        this.maximumPoolSize = maximumPoolSize;


    }

    public static void testCustomPoolExecutor(){

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new CustomThreadFactory("测试"));


        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(4,5,30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),"测试");


        scheduledExecutorService.scheduleWithFixedDelay(() -> {

            try{

                SendEmail sendEmail = new SendEmail();

                Thread sendPhone = new Thread(new SendPhone());

                Thread sendWeChat = new Thread(new SendWeChat());

                executor.submit(sendEmail);
                executor.submit(sendPhone);
                executor.submit(sendWeChat);



//                for (int i = 0; i < 3; i++) {
//                    executor.submit(
//                            () -> {
//                                try {
//                                    TimeUnit.SECONDS.sleep(1);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                System.out.println(Thread.currentThread().getName()+"执行完成！");
//                            }
//                    );
//                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {
//                    executorService1.shutdown();
            }
        }, 1,6, TimeUnit.SECONDS);

        while (true){

        }

    }

    public static void testNestLoopThread(){

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"执行...");
                }).start();
            }
        }).start();

    }

    public static void testScheduledExecutorService(){

//        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(1);
//        System.out.println("3秒后开始执行计划线程池服务..." + new Date());
//        scheduledExecutorService1.schedule(() ->{
//            System.out.println(111);
//            try{
//                for (int i = 0; i < 3; i++) {
//                    executorService1.submit(
//                        () -> {
//                            try {
//                                TimeUnit.SECONDS.sleep(1);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(Thread.currentThread().getName()+"执行完成！");
//                        }
//                    );
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                    executorService1.shutdown();
//            }
//        }, 3, TimeUnit.SECONDS);
//        while (true){
//
//        }




//
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
//                new BasicThreadFactory.Builder().namingPattern("task-%d").daemon(true).build());



//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            try{
//                for (int i = 0; i < 3; i++) {
//                    executorService1.submit(
//                            () -> {
//                                try {
//                                    TimeUnit.SECONDS.sleep(1);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                System.out.println(Thread.currentThread().getName()+"执行完成！");
//                            }
//                    );
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
////                    executorService1.shutdown();
//            }
//        }, 1,3, TimeUnit.SECONDS);


//        while (true){
//
//        }


    }



}

class SendEmail extends Thread{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发送邮件！");
    }
}


class SendPhone implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发送短信！");
    }
}


class SendWeChat implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发送微信！");
    }
}












