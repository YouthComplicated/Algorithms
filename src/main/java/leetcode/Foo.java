package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    private int num;
    private ReentrantLock lock;
    private Condition c1;
    private Condition c2;
    private Condition c3;
    public Foo() {
        this.num = 1;
        this.lock = new ReentrantLock();
        this.c1 = lock.newCondition();
        this.c2 = lock.newCondition();
        this.c3 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        try{
            while(num!=1){
                c1.await();
            }
            printFirst.run();
            num = 2;
            c2.signal();
        }finally {
            lock.unlock();
        }
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try{
            while(num!=2){
                c2.await();
            }
            printSecond.run();
            num = 3;
            c3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try{
            while(num!=3){
                c3.await();
            }
            printThird.run();
        }finally {
            lock.unlock();
        }
    }
}

