package thread.tool.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nj
 * @date: 2020-04-02 18:28
 * @version: 0.0.1
 */
public class ConsumerTest {


    public static void main(String[] args) {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " \t 生产线程启动");
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myProd").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " \t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myCons").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("时间到，停止活动");
        myResource.stop();


    }

}


class MyResource{

    /**
     * 是够进行消费交互
     */
    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;


    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("BlockingQueue:" + blockingQueue.getClass().getName());
    }

    /**
     * 生产消息
     * @throws InterruptedException
     */
    public void myProd () throws InterruptedException {
        String data = null;
        boolean returnValue = false;

        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(returnValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列数据 " + data + " 成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列数据" + data + " 失败");
            }

            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+" \t 停止表示 flag " + flag);
    }

    /**
     * 消费消息
     */
    public void myConsumer() throws InterruptedException {
        String result = null;
        while (flag){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == result || "".equalsIgnoreCase(result)){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超出2m没有取到消费退出" );
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列" + result + "成功！");
        }
    }


    public void stop(){
        flag = false;
    }



}