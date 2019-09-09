package thread.proandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MallQueue {

    private int count;

    private final int MAX_COUNT = 20;

    private Lock lock = new ReentrantLock();
    Condition proCon = lock.newCondition();
    Condition conCon = lock.newCondition();

    //生产
    public  void produce(){
        lock.lock();
        while(count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量达到上限，生产者停止生产。");
                proCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count ++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产，当前库存为：" + count);
        conCon.signal();
//        notifyAll();
        lock.unlock();
    }

    //消费
    public  void consume(){
        lock.lock();
        while(count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量为零，消费者等待。");
//                wait();
                conCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        System.out.println(Thread.currentThread().getName() + " 消费者消费，当前库存为：" + count);
//        notifyAll();
        proCon.signal();
        lock.unlock();
    }
}
