package thread;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nj
 * @date: 2020-11-30 13:50
 * @version: 0.0.1
 */
public class LockInterr {



    static  Lock lock = new ReentrantLock();


    public void doSomeThing3(Thread thread) {
        try {
//            lock.lockInterruptibly();
            lock.lock();
            System.out.println(thread.getName() + " 得到了锁.");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread()+"111111");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
            System.out.println(thread.getName() + " interrupted.");
        } finally {
            System.out.println(thread.getName() + " 释放了锁.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {


//        for (int i = 0; i < 2; i++) {
//            new Thread(()->{
//                try {
//                    System.out.println(Thread.currentThread().getName());
////                    lock.lockInterruptibly();
//                    lock.lock();
//                    TimeUnit.SECONDS.sleep(5);
//                    System.out.println(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    System.out.println("当前线程捕捉异常:"+Thread.currentThread().getName());
//                }finally {
//                    lock.unlock();
//                }
//
//            }).start();
//        }


        LockInterr lockDemo = new LockInterr();
        Thread threada = new Thread("Thread A") {
            @Override
            public void run() {
                lockDemo.doSomeThing3(Thread.currentThread());
            }
        };

        threada.start();

//        Thread threadb = new Thread("Thread B") {
//            @Override
//            public void run() {
//                lockDemo.doSomeThing3(Thread.currentThread());
//            }
//        };
//        threadb.start();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        threada.interrupt();





    }
}