package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: nj
 * @date: 2020-11-30 15:03
 * @version: 0.0.1
 */
public class Quest6_park {


    public static void main(String[] args) throws InterruptedException {



        Thread th = new Thread(() -> {
            System.out.println(1111);
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("park--before:" + Thread.currentThread().isInterrupted());
                LockSupport.park(Thread.currentThread());
                Thread.currentThread().interrupt();
                System.out.println("park--after:" + Thread.currentThread().isInterrupted());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");


//        Thread th1 = new Thread(() -> {
//            System.out.println(1111);
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"t2");



        th.start();


        TimeUnit.SECONDS.sleep(1);
        System.out.println("xxxxlllll");
        System.out.println("park--before:" + th.isInterrupted());
        LockSupport.unpark(th);
        System.out.println("park--after:" + th.isInterrupted());



    }
}