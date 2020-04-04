package thread.pool;

import java.util.concurrent.*;

/**
 * 生产环境自动封装相应的线程池，不使用JDK自带的创建方式
 *  封装的通用性、业务的结合
 */
public class MyThreadDemo {

    /**
     *   public ThreadPoolExecutor(
     *    int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
     *    BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,
     *    RejectedExecutionHandler handler) {
     *
     *   1、拒绝策略 ....
     *
     *  >> AbortPolicy:直接抛出异常阻止系统正常运行  阻止系统正常运行 会发生什么？？？
     *
     *
     *  >> CallerRunsPolicy:在任务被拒绝添加后，会调用当前线程池的所在的线程去执行被拒绝的任务。
     *
     *   缺点是可能会阻塞主线程，让主线程
     *
     *
     *  >> DiscardOldestPolicy
     *
     *
     *  >> DiscardPolicy
     *
     *
     */
    static ExecutorService executorService1 = new ThreadPoolExecutor(2,3,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    static ExecutorService executorService2 = new ThreadPoolExecutor(2,3,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    static ExecutorService executorService3 = new ThreadPoolExecutor(2,3,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    static ExecutorService executorService4 = new ThreadPoolExecutor(2,3,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardPolicy());




    public static void main(String[] args) {


//        System.out.println(Integer.SIZE - 3);


//        testAbortPolicy();


//        testCallerRunsPolicy();


//        testDiscardOldestPolicy();


//        testDiscardPolicy();



    }


    /**
     * 15个任务，只有8个任务执行成功
     */
    public static void testDiscardPolicy(){
        try{
            for (int i = 0; i < 15; i++) {
                executorService4.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService4.shutdown();
        }
    }





    /**
     * 15个任务，只有8个任务执行成功
     */
    public static void testDiscardOldestPolicy(){
        try{
            for (int i = 0; i < 15; i++) {
                executorService3.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService3.shutdown();
        }
    }


    /**
     *
     * 直接丢弃
     *
     * 为甚么会存在 多次的main线程
     *
     * main线程+线程池中线程 = 15
     *
     *
     */
    public static void testCallerRunsPolicy(){

        try{
            for (int i = 0; i < 15; i++) {
                executorService2.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService2.shutdown();
        }
    }




    /**
     * 测试abortPolicy策略
     *
     * new ThreadPoolExecutor(2,3,1,
     *             TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
     *             new ThreadPoolExecutor.AbortPolicy());
     *
     *  int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
     *    BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,
     *    RejectedExecutionHandler handler) {
     *
     *   corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,RejectHander
     *
     *    2, 3, 1, 秒, e
     *
     *
     *    没有执行所有的线程会中断
     *
     *      pool-1-thread-1执行完成！
     *      pool-1-thread-3执行完成！
     *      pool-1-thread-1执行完成！
     *      pool-1-thread-2执行完成！
     *      pool-1-thread-1执行完成！
     *      pool-1-thread-3执行完成！
     *      pool-1-thread-1执行完成！
     *      pool-1-thread-2执行完成！
     *      java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@6e8cf4c6 rejected from java.util.concurrent.ThreadPoolExecutor@12edcd21[Running, pool size = 3, active threads = 2, queued tasks = 0, completed tasks = 6]
     * 	    at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
     * 	    at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
     * 	    at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
     * 	    at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
     * 	    at thread.pool.MyThreadDemo.testAbortPolicy(MyThreadDemo.java:114)
     * 	    at thread.pool.MyThreadDemo.main(MyThreadDemo.java:51)
     *
     */
    public static void testAbortPolicy(){
        try{
            for (int i = 0; i < 15; i++) {
                executorService1.submit(
                        () -> System.out.println(Thread.currentThread().getName()+"执行完成！")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService1.shutdown();
        }
    }



}