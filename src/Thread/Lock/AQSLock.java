package Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class AQSLock  implements  Lock {

    private Helper helper = new Helper();

    /**
     * <p>Subclasses should be defined as non-public internal helper
     * classes that are used to implement the synchronization properties
     * of their enclosing class.  Class
     * {@code AbstractQueuedSynchronizer} does not implement any
     * synchronization interface.  Instead it defines methods such as
     * {@link #acquireInterruptibly} that can be invoked as
     * appropriate by concrete locks and related synchronizers to
     * implement their public methods.
     */
    private class Helper extends  AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            /**
             *  第一个线程进来，可以拿到锁，因此我们可以返回true
             *  第二个线程进来，则拿不到锁，返回false。
             *  有种特例，如果当前进来的线程和当前保存的线程是同一个线程，则可以拿到锁，但是有代价，要更新状态值
             *
             * 	如何判断是第一个线程进来还是其他线程进来？
             */
            int state = getState();
            Thread thread = Thread.currentThread();
            if(state == 0){
                //获取锁
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            }else if(getExclusiveOwnerThread() == thread){
                setState(state+1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - arg;
            boolean flag = false;
            if(state == 0){
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);

            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return  helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        //helper.tryRelease(1);
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }
}
