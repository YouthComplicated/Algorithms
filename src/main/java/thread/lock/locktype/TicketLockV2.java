package thread.lock.locktype;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 *
 *
 * TicketLock存在的问题:
 *
 * 多处理器系统上，每个进程/线程占用的处理器都在读写同一个变量serviceNum ，每次读写操作都必须在多个处理器缓存之间进行缓存同步，
 * 这会导致繁重的系统总线和内存的流量，大大降低系统整体的性能。
 *
 *（必须要到主内存读取，并阻止其他cpu修改）。
 *
 * @author: nj
 * @date: 2020-03-27 20:37
 * @version: 0.0.1
 */
public class TicketLockV2 {

    /**
     * 服务号
     */
    private AtomicInteger serviceNum = new AtomicInteger();
    /**
     * 排队号
     */
    private AtomicInteger ticketNum = new AtomicInteger();
    /**
     * 新增一个ThreadLocal，用于存储每个线程的排队号
     */
    private ThreadLocal<Integer> ticketNumHolder = new ThreadLocal<>();

    public void lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        // 获取锁的时候，将当前线程的排队号保存起来
        ticketNumHolder.set(currentTicketNum);
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
    }
    public void unlock() {
        // 释放锁，从ThreadLocal中获取当前线程的排队号
        Integer currentTickNum = ticketNumHolder.get();
        serviceNum.compareAndSet(currentTickNum, currentTickNum + 1);
    }
}