package thread.tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nj
 * @date: 2020-02-06 14:10
 * @version: 0.0.1
 */
public class ConditionTest {


    /**
     * 线程之间通信、同步、判断
     */

    int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Thread threadA = new Thread(new A());
    Thread threadB = new Thread(new B());
    Thread threadC = new C();

    private void print1(){
        lock.lock();
        try{
            while (number != 1){
                condition1.await();
            }
            threadA.start();
            number = 2;
            condition2.signal();
            while (number != 2 ){
                condition2.await();
            }
            threadB.start();
            number = 3;
            condition3.signal();

            while (number != 3){
                condition3.await();
            }
            threadC.start();
            condition1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ConditionTest test = new ConditionTest();

        new Thread(()->{
            test.print1();
        },"AA").start();

        new Thread(()->{
            test.print1();
        },"BB").start();





    }




}


class A implements Runnable{
    @Override
    public void run() {
        System.out.println("A......");
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class B implements Runnable{
    @Override
    public void run() {
        System.out.println("B......");
        for (int i = 0; i < 2 ; i++) {
            System.out.println(Thread.currentThread().getName()+":aa");
        }
    }
}

class C extends Thread{
    @Override
    public void run() {
        System.out.println("C.....");
        for (int i = 0; i < 3 ; i++) {
            System.out.println(Thread.currentThread().getName()+":bb");
        }

    }
}