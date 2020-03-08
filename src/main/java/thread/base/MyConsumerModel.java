package thread.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nj
 * @date: 2020-02-06 16:33
 * @version: 0.0.1
 */
public class MyConsumerModel {


    /**
     * 生产消费模型 生产1 消费1
     */
    private volatile  boolean flag = true;
    private BlockingQueue<String> blockingQueue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public MyConsumerModel(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws Exception {
        boolean returnVal;
        String data;
        while(flag){
            data = atomicInteger.getAndIncrement()+"";
            returnVal = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if(returnVal) {
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName()+"添加结束-FLAG:"+flag);
    }


    public void stop(){
        flag = false;
    }


    public void pop() throws Exception {
        String data;
        while(flag){
            data = blockingQueue.poll(2, TimeUnit.SECONDS);

            if(null == data || "".equalsIgnoreCase(data)){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"超过2秒没有取到退出！！！");
                return ;
            }
            System.out.println(Thread.currentThread().getName()+"消费成功-FLAG:"+flag);
        }
    }


    public static void main(String[] args) {
        MyConsumerModel myConsumerModel = new MyConsumerModel(new ArrayBlockingQueue(3));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                myConsumerModel.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            try {
                myConsumerModel.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("时间到,停止活动");
        myConsumerModel.stop();
    }







}