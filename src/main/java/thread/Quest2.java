package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * 使用CountDownLatch 如下实现不可以
 *
 * @author: nj
 * @date: 2020-11-27 21:18
 * @version: 0.0.1
 */
public class Quest2 {

    List list = new ArrayList<String>();

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        Quest2 quest1 = new Quest2();



        new Thread(()->{
                System.out.println("T2启动");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 结束");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        new Thread(()->{
            System.out.println("T1.....");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    quest1.list.add(i+"");

                    /**
                     * 唤醒T2, 但是自己会继续执行相当于 没有锁住，可以使用两把锁
                     */
                    latch.countDown();
                    System.out.println(1111);

//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
        }).start();



    }
}