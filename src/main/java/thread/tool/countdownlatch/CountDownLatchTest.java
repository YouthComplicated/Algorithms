package thread.tool.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-02-05 17:32
 * @version: 0.0.1
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 聚会吃饭案例
         */
//        party();


        destroyWorld();

    }


    private static void destroyWorld() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "国,灭亡");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("秦统一");
    }

    private static void party() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" come in...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            },String.valueOf(i)).start();

//            countDownLatch.countDown();
        }

        /**
         * Exception in thread "main" java.lang.IllegalMonitorStateException
         * 	at java.lang.Object.wait(Native Method)
         * 	at java.lang.Object.wait(Object.java:502)
         * 	at thread.tool.countdownlatch.CountDownLatchTest.main(CountDownLatchTest.java:29)
         */
//        try {
//            Thread.currentThread().wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        countDownLatch.await();

        System.out.println("we can eat it!!!");
    }
}