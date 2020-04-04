package thread.tool.LockSupportTest;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 *
 *
 * @author: nj
 * @date: 2020-04-01 15:50
 * @version: 0.0.1
 */
public class LockSupportDemo {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"come in....");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("park之前.....");
            LockSupport.park();
            System.out.println("park之后.....");
        });

        thread.start();

        Thread.sleep(1);
        System.out.println("unPark之前.....");
        LockSupport.unpark(thread);
        System.out.println("unPark之后.....");


    }
}