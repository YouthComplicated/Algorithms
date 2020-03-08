package thread.tool;

import java.util.concurrent.*;

/**
 * @author: nj
 * @date: 2020-02-07 14:48
 * @version: 0.0.1
 */
public class MyThreadDemo {


    /**
     * 生产环境自动封装相应的线程池，不使用JDK自带的创建方式
     *  封装的通用性、业务的结合
     */
    public static void main(String[] args) {
        /**
         *   public ThreadPoolExecutor(
         *    int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
         *    BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,
         *    RejectedExecutionHandler handler) {
         *
         *   1、拒绝策略 ....
         *
         *
         */
        ExecutorService executorService1 = new ThreadPoolExecutor(2,3,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());


        ExecutorService executorService2 = new ThreadPoolExecutor(2,3,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        ExecutorService executorService3 = new ThreadPoolExecutor(2,3,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        ExecutorService executorService4 = new ThreadPoolExecutor(2,3,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());


        try{
            for (int i = 0; i < 10; i++) {
                executorService1.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService1.shutdown();
        }

        try{
            for (int i = 0; i < 10; i++) {
                executorService2.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService2.shutdown();
        }


//        try{
//            for (int i = 0; i < 10; i++) {
//                executorService3.submit(
//                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
//                );
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            executorService3.shutdown();
//        }
//
//        try{
//            for (int i = 0; i < 10; i++) {
//                executorService4.submit(
//                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
//                );
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            executorService4.shutdown();
//        }



    }
}