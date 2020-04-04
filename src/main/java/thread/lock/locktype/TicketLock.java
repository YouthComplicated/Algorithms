package thread.lock.locktype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 公平的自旋锁：
 *
 * 每当有线程获取锁的时候，就给该线程分配一个递增的id，我们称之为排队号，同时锁对应一个服务号，每当有线程释放锁，服务号就会递增，
 * 此时如果服务号与某个线程排队号一致，那么该线程就获得锁，由于排队号是递增的，所以就保证了最先请求获取锁的线程可以最先获取到锁，就实现了公平性。
 *
 * 自增的排队号，类似队列
 *
 * 缺点：将它的排队号返回，等该线程释放锁的时候，需要将该排队号传入。但这样是有风险的，因为这个排队号是可以被修改的，一旦排队号被不小心修改了，
 * 那么锁将不能被正确释放。
 *
 *
 * @author: nj
 * @date: 2020-03-27 20:15
 * @version: 0.0.1
 */
public class TicketLock {

    private AtomicInteger serviceNum = new AtomicInteger();

    private AtomicInteger ticketNum = new AtomicInteger();

    public int lock(){
        int currTicketNum = ticketNum.getAndIncrement();
        System.out.println(Thread.currentThread().getName()+"-ticketNum:" + currTicketNum);
        while(currTicketNum != serviceNum.get()){
//            System.out.println(Thread.currentThread().getName()+" 排队等待。。。");
        }
        return currTicketNum;
    }

    public void unlock(int ticketNum){
        serviceNum.compareAndSet(ticketNum, ticketNum + 1);
    }


    public static void main(String[] args) {

        /**
         * 一把锁，锁住相当多的线程
         */
        TicketLock ticketLock = new TicketLock();


        new Thread(()->{
            int lock = ticketLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in--"+lock);
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                ticketLock.unlock(lock);
            }
        },"AA").start();


        new Thread(()->{
            int lock = ticketLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in--"+lock);
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                ticketLock.unlock(lock);
            }
        },"BB").start();


        new Thread(()->{
            int lock = ticketLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in--"+lock);
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                ticketLock.unlock(lock);
            }
        },"CC").start();


    }



}