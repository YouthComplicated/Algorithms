package thread.tool.LockSupportTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 *
 *
 * 匿名内部类如何调用unpark()方法  好像无法调用方法？？？
 *
 *
 * @author: nj
 * @date: 2020-04-01 16:05
 * @version: 0.0.1
 */
public class LockSupportDemo1 {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        new Thread(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"\t"+"已经到现场...");
            try {
                System.out.println("park......");
                LockSupport.park();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("unPark......");

//                LockSupport.unpark(Thread.currentThread());
                LockSupport.unpark(thread);

                System.out.println("线程唤醒......");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
            }
        },String.valueOf(6)).start();





    }
}