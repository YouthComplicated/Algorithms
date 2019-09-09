package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private int value;

    Lock lock = new ReentrantLock();

    public  int getNext() {
//        lock lock = new ReentrantLock();
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }

    public static void main(String[] args) {
        LockTest s = new LockTest();
//		while(true) {
//			System.out.println(s.getNext());
//		}

        new Thread(()->{
            while(true) {
                System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
