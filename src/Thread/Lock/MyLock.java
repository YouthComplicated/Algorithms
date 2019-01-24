package Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义实现锁并且可重入
 */
public class MyLock implements Lock {

    private boolean isLock = false;

    private Thread lockThread = null;

    private int lockCount;

    @Override
    public synchronized void lock() {
//        if(isLock){
        Thread currentThread = Thread.currentThread();
        //锁被别的线程拿到并且当前线程不是被锁住的线程则wait
        while (isLock && currentThread != lockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockThread  = currentThread;
        lockCount ++;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread() == lockThread){
            lockCount --;
            if( lockCount == 0){
                notify();
                isLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
