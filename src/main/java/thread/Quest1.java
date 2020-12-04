package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * 两个线程  一个线程启动监控集合=5  提示
 * @author: nj
 * @date: 2020-11-27 20:58
 * @version: 0.0.1
 */
public class Quest1 {

    List list = new ArrayList<String>();

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {

        Quest1 quest1 = new Quest1();

        final Object lock = new Object();


        new Thread(()->{
            synchronized (lock){
                System.out.println("T2启动");
                if(quest1.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2 结束");
                //唤醒T1
                lock.notify();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        new Thread(()->{
            System.out.println("T1.....");

            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    quest1.list.add(i+"");
                    if(quest1.size() == 5 ){
                        lock.notify();
                        //释放锁，T2才能执行
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }).start();


    }
}
