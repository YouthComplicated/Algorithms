package Thread.locktype;

import java.util.Random;

/**
 * 自旋锁
 */
public class SpinLock {

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 线程执行...");
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 线程执行完毕...");
        }).start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 线程执行...");
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 线程执行完毕...");
        }).start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 线程执行...");
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 线程执行完毕...");
        }).start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 线程执行...");
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 线程执行完毕...");
        }).start();

        //todo 此处有问题  为什么Thread.activeCount() == 2
        while(Thread.activeCount() != 1) {
            // 自旋
            //System.out.println("所有的线程执行完毕了...");
            System.out.println(Thread.activeCount());
        }
        System.out.println("所有的线程执行完毕了...");

    }
}
