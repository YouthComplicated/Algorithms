package thread;

import org.omg.CORBA.TIMEOUT;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nj
 * @date: 2020-10-30 21:18
 * @version: 0.0.1
 */
public class MyConsumerTest {


    private volatile int size;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    static Lock lock = new ReentrantLock();

    public MyConsumerTest(int size) {
        this.size = size;
    }


    public void prod() throws InterruptedException {
        while (true){
            while (blockingQueue.size() <= 3){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("加入对列");
                blockingQueue.add(atomicInteger.getAndIncrement());
                System.out.println("队列大小:" + blockingQueue.size());
            }
        }
    }

    public void consumer(){
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (blockingQueue.size() > 0){
                System.out.println("cousumer:" + blockingQueue.poll());
            }
        }

    }

    public static void main(String[] args) {


        MyConsumerTest myConsumerTest = new MyConsumerTest(3);


        ExecutorService executorService = Executors.newFixedThreadPool(2);


        executorService.submit(()->{
            myConsumerTest.consumer();
        });

        executorService.submit(()->{
            try {
                myConsumerTest.prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });





    }
}