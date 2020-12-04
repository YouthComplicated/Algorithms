package thread;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: nj
 * @date: 2020-11-27 21:26
 * @version: 0.0.1
 */
public class Quest3 {

    List list = new ArrayList<String>();

    public int size(){
        return list.size();
    }

    static Thread t1 = null, t2 = null;
    public static void main(String[] args) throws InterruptedException {


        Quest3 quest3 = new Quest3();
        t1 = new Thread(()->{
            System.out.println("T1.....");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                quest3.list.add(i+"");
                if(i == 5){
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }



            }
        });

        t2 = new Thread(()->{
            System.out.println("T2启动");
            LockSupport.park();
            System.out.println("T2结束");
            LockSupport.unpark(t1);

        });

        /**
         * 必需t2 先执行
         */
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        t1.start();


    }
}