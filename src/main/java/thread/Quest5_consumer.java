package thread;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class Quest5_consumer {


    public static void main(String[] args) {



        Container<String> container = new Container<>();


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


class Container<T>{

    private LinkedList<T> data = new LinkedList<T>();

    public volatile int size;

    private static final int MAX = 10;

    public int getSize(){
        return size;
    }


    public synchronized  void add(T t) throws InterruptedException {
        if(size == MAX){
            System.out.println("生产线程已满");
            this.wait();
        }
        data.add(t);
        size++;
        this.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        T t = null;
        while (size == 0){
            //阻塞
            this.wait();
        }
        t = data.removeFirst();
        size--;
        this.notifyAll();
       return t;
    }



}