package thread.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: nj
 * @date: 2020-03-25 08:16
 * @version: 0.0.1
 */
public class TestLongAddr {

    private static long l = 2;

    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        LongAdder adder = new LongAdder();
        adder.add(l);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.submit(()->{
                adder.increment();
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();


        service.shutdown();
        System.out.println("最终数量为："+adder.sum());

//        Thread.sleep(4000);
//        System.out.println("active count:" + Thread.activeCount());
//        while (Thread.activeCount() == 102){
//            service.shutdown();
//            System.out.println("最终数量为："+adder.sum());
//        }
    }
}