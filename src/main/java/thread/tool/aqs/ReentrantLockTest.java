package thread.tool.aqs;

import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nj
 * @date: 2020-03-29 19:02
 * @version: 0.0.1
 */
public class ReentrantLockTest {


    private static Lock fairLock = new ReentrantLock(true);
    private static Lock unFairLock = new ReentrantLock();

    private static Lock fairLock1 = new ReentrantLock2(true);
    private static Lock unFairLock1 = new ReentrantLock2();


    @Test
    public void fair() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                fairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+":" + "come in ...");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    fairLock.unlock();
                }
            }, String.valueOf(i)).start();
        }

        Thread.sleep(5000);
    }

    @Test
    public void unfair() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                unFairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+":" + "come in ...");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    unFairLock.unlock();
                }
            }).start();
        }

        Thread.sleep(5000);
    }





    @Test
    public void fair1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                fairLock1.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+":" + "come in ..."
                    + ((ReentrantLock2)fairLock1).getQueuedThreads());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    fairLock1.unlock();
                }
            }, String.valueOf(i)).start();
        }

        Thread.sleep(5000);
    }

    @Test
    public void unfair1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                unFairLock1.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+":" + "come in ..."
                            + ((ReentrantLock2)unFairLock1).getQueuedThreads());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    unFairLock1.unlock();
                }
            }).start();
        }

        Thread.sleep(5000);

    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                unFairLock1.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+":" + "come in ..."
                            + ((ReentrantLock2)unFairLock1).getQueuedThreads());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    unFairLock1.unlock();
                }
            }).start();
        }
    }
}


class ReentrantLock2 extends ReentrantLock{
    public ReentrantLock2() {
        super();
    }

    public ReentrantLock2(boolean fair) {
        super(fair);
    }

    @Override
    public void lock() {
        super.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        super.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        return super.tryLock();
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return super.tryLock(timeout, unit);
    }

    @Override
    public void unlock() {
        super.unlock();
    }

    @Override
    public Condition newCondition() {
        return super.newCondition();
    }

    @Override
    public int getHoldCount() {
        return super.getHoldCount();
    }

    @Override
    public boolean isHeldByCurrentThread() {
        return super.isHeldByCurrentThread();
    }

    @Override
    public boolean isLocked() {
        return super.isLocked();
    }

    @Override
    protected Thread getOwner() {
        return super.getOwner();
    }

    @Override
    public boolean hasWaiters(Condition condition) {
        return super.hasWaiters(condition);
    }

    @Override
    public int getWaitQueueLength(Condition condition) {
        return super.getWaitQueueLength(condition);
    }

    @Override
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        return super.getWaitingThreads(condition);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Collection<Thread> getQueuedThreads() {
//        StringBuilder sb = new StringBuilder();
//        super.getQueuedThreads().forEach(x->sb.append(x.getName()).append(","));
        return super.getQueuedThreads();
    }
}