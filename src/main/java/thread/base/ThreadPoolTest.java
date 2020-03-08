package thread.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: nj
 * @date: 2020-02-06 19:30
 * @version: 0.0.1
 */
public class ThreadPoolTest {


    public static void main(String[] args) {

        /**
         * 主要特点如下:
         *
         * 1.创建一个定长线程池,可控制线程的最大并发数,超出的线程会在队列中等待.
         *
         * 2.newFixedThreadPool创建的线程池corePoolSize和MaxmumPoolSize是 相等的,它使用的的LinkedBlockingQueue
         */

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);

        try{
            for (int i = 0; i < 10; i++) {
                executorService3.submit(()->{
                    System.out.println(Thread.currentThread().getName()+":AAA");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService3.shutdown();
        }




    }
}