package leetcode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {


    //原子类保证原子性，也可以使用volatile
    //普通的int被读取，会被读入内存的缓存中，完成加减乘除后再放回内存中，而每一个线程都有自己的寄存器，这样子会导致可能读取不到最新的数据
    //volatile则可以直接在主内存读写，当一个线程更新了值，其他线程能够及时获知。
    AtomicInteger size = new AtomicInteger(0);
    private volatile int capacity;
    //自己实现阻塞队列，需要一个容器，内部实现了一个node，如果改造为不只是int的，使用T泛型
    private LinkedList<Integer> container;

    //可重入锁
    private static ReentrantLock lock = new ReentrantLock();
    Condition procuder = lock.newCondition();//用来通知生产（入队）线程等待await还是可以执行signal
    Condition consumer = lock.newCondition();//用来通知消费（出队）线程等待await还是可以执行signal

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        container = new LinkedList<>();
    }

    /**
     * 入队
     *
     * @param element
     * @throws InterruptedException
     */
    public void enqueue(int element) throws InterruptedException {
        //每一个线程都会获得锁，但是如果条件不满足则会阻塞
        lock.lock();
        try {
            //阻塞的话必须用循环，让这个线程再次获得cpu片段的时候能够够执行
            while (size.get() >= capacity) {
                //入队线程阻塞，把锁释放？
                procuder.await();
            }
            container.addFirst(element);
            size.incrementAndGet();

            //通知出队线程
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                consumer.await();
            }
            int lastValue = container.getLast();
            container.removeLast();
            size.decrementAndGet();

            //通知入队线程
            procuder.signal();
            return lastValue;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size.get();
        } finally {
            lock.unlock();
        }
    }
}

