package thread.tool.aqs;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * 互斥锁
 *
 * @author: nj
 * @date: 2020-03-30 11:25
 * @version: 0.0.1
 */
public class Mutex implements Lock, Serializable {



    private static class Sync extends AbstractQueuedSynchronizer{

        protected Sync() {
            super();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if(getState() == 0){
                throw  new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     *
     * @return
     */
    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    public static void main(String[] args) {

        Mutex lock = new Mutex();
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" come into.....");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            },String.valueOf(i)).start();
        }


    }





}