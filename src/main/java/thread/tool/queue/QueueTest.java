package thread.tool.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nj
 * @date: 2020-02-06 13:42
 * @version: 0.0.1
 */
public class QueueTest {

    private int number = 0;

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add(){
        lock.lock();
        try{
            //多线程不能用if判断
            while (number != 0){
                //wait
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName()+":"+number);
            //此处不能用notifyAll原因为？？？
//            condition.notifyAll();
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void delete(){
        lock.lock();
        try{
            while (number == 0){
                //wait
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName()+":"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        QueueTest queueTest = new QueueTest();

//        for (int i = 1; i <= 3; i++) {
//            new Thread(()->{
//                queueTest.add();
//            },String.valueOf(i)).start();
//        }
//
//        for (int i = 1; i <= 3; i++) {
//            new Thread(()->{
//                queueTest.delete();
//            },String.valueOf(i)).start();
//        }

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    queueTest.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();


        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    queueTest.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();


    }
}