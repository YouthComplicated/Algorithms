package thread.locktype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 * 自旋锁
 * @author: nj
 * @date: 2020-02-05 16:14
 * @version: 0.0.1
 */
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }


    private void unlock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(thread, null)){

        }
    }

    public static void main(String[] args) {
        MySpinLock spinLock = new MySpinLock();
        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in");
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"AA").start();


        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"BB").start();


    }

}