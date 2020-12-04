package thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 *
 * wait/notify 可以
 *
 * condition 一个或者两个
 *
 *
 *
 * @author: nj
 * @date: 2020-11-27 21:50
 * @version: 0.0.1
 */
public class Quest4 {


    static Thread t1, t2;


    static Exchanger<String> ec = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {


        t1 = new Thread(()->{
            for (char i = 'a'; i <= 'z'; i++) {
                System.out.print(i);
                try {
                    ec.exchange("T1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                LockSupport.unpark(t2);
//                LockSupport.park();
            }
        });

        t2 = new Thread(()->{
            for (int i = 0; i < 26; i++) {

                try {
                    ec.exchange("T2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i);


//                LockSupport.park();
//                System.out.print(i);
//                LockSupport.unpark(t1);
            }
        });


        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();

    }
}