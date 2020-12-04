package thread;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 生产消费模型
 *
 * 队列超过10个停止加入
 *
 * 生产者  条件
 *
 * 消费者条件： 为null 不消费，阻塞
 *
 *
 * @author: nj
 * @date: 2020-11-27 21:57
 * @version: 0.0.1
 */
public class Quest6_consumer {


    public static void main(String[] args) {



        Container1<String> container = new Container1<>();


        //生产线程
        new Thread(()->{
            System.out.println("生产线程启动");
            int i = 0;
            while (true){
                try {
                    container.add((i++)+ "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();

        new Thread(()->{
            System.out.println("消费线程启动");
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("消费了" + container.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();


    }
}


class Container1<T>{

    private LinkedList<T> data = new LinkedList<T>();

    public volatile int size;

    private static final int MAX = 10;

    public int getSize(){
        return size;
    }

    Lock lock = new ReentrantLock();

    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public  void add(T t) throws InterruptedException {
        lock.lock();
        try{
            if(size == MAX){
//                System.out.println("生产线程已满");
                producer.await();
            }
            data.add(t);
            size++;
            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public  T get() throws InterruptedException {
        T t = null;
        lock.lock();
        try{
            while (size == 0){
                consumer.await();
            }
            t = data.removeFirst();
            size--;
            producer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
       return t;
    }



}