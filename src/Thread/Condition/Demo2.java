package Thread.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

        Demo d = new Demo();
        A a = new A(d);
        B b = new B(d);
        C c = new C(d);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }
}

class A1 implements Runnable {

    private Demo demo;

    public A1(Demo demo) {
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

    private Demo demo;

    public B1(Demo demo) {
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

    private Demo demo;

    public C1(Demo demo) {
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