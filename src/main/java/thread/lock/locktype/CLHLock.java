package thread.lock.locktype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 *
 * CLH锁是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，它不断轮询前驱的状态，
 * 如果发现前驱释放了锁就结束自旋，获得锁。
 *
 * @author: nj
 * @date: 2020-03-27 20:42
 * @version: 0.0.1
 */
public class CLHLock {

    /**
     * 定义一个节点，默认的lock状态为true
     */
    public static class CLHNode {
        private volatile boolean isLocked = true;
    }
    /**
     * 尾部节点,只用一个节点即可，使用volatile 保证可见性
     */
    private volatile CLHNode tail;

    /**
     * 变量副本，生命周期随每个线程
     */
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();


    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");

    public void lock() {
        // 新建节点并将节点与当前线程保存起来
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        /**
         *
         *
         * 将新建的节点设置为尾部节点，并返回旧的节点（原子操作），这里旧的节点实际上就是当前节点的前驱节点
         *
         *
         * this: new CLHLock() 全局变量
         *
         * AA线程过来,preNode == null, tail == nodeAA,
         *
         * BB线程过来,preNode == nodeAA,tail == nodeBB,
         * 当unlock中node.isLocked = false;
         * 此时 while (preNode.isLocked) {} 中preNode中为nodeAA
         *
         * CC线程过来,preNode == nodeBB,tail == nodeCC
         *
         */
        CLHNode preNode = UPDATER.getAndSet(this, node);
        System.out.println(Thread.currentThread().getName()+"-preNode:"+preNode+"this:"+this.toString());
        if (preNode != null) {
            // 前驱节点不为null表示当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while (preNode.isLocked) {
//                if(preNode == null){
//                    System.out.println(Thread.currentThread().getName()+"-preNode:"+preNode+"######");
//                }
            }
            preNode = null;
            LOCAL.set(node);
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }
    public void unlock() {
        // 获取当前线程对应的节点
        CLHNode node = LOCAL.get();
        // 如果tail节点等于node，则将tail节点更新为null，同时将node的lock状态职位false，表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this, node, null)) {
            /**
             * 此处将前驱节点属性置为false, 后续的线程就会立马感知么？？？？
             */
            node.isLocked = false;
        }
        /**
         * 此处是为了垃圾回收么？？？？
         */
        node = null;
    }

    private static void test(){
        System.out.println(Thread.currentThread().getName()+":come in");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CLHLock lock = new CLHLock();
        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"AA").start();


        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"BB").start();

        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"CC").start();


    }
}