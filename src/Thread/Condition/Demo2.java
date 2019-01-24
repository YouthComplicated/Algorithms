package Thread.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用conditon代替wait-notify
 * 指定叫醒的线程
 */
public class Demo2 {
    private int signal;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();


    public void a() {
        lock.lock();
        while(signal != 0 ) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal ++;
        //叫醒b线程
        b.signal();
        lock.unlock();
    }

    public  void b() {
        lock.lock();
        while(signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal ++;
        c.signal();
        lock.unlock();
    }

    public  void c () {
        lock.lock();
        while(signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {

        Demo2 d = new Demo2();
        A1 a = new A1(d);
        B1 b = new B1(d);
        C1 c = new C1(d);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }
}

class A1 implements Runnable {

    private Demo2 demo;

    public A1(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true) {
            demo.a();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class B1 implements Runnable {

    private Demo2 demo;

    public B1(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true) {
            demo.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class C1 implements Runnable {

    private Demo2 demo;

    public C1(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true) {
            demo.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}