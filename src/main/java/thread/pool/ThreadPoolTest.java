package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);


    private  Integer len = 1;

    private static int a = 0, b = 0;


    public static void main(String[] args) {

            new Thread(()->{
                while (true){
                    ++a;
                    System.out.println(a);
                    try {
//                    System.out.println(Thread.currentThread().toString());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
    }

    /**
     * ThreadPoolExecutor初始化
     */
    @Test
    public void test01(){

//        ThreadFactory threadFactory = new MyThreadFactory("test");
//        Thread thread = threadFactory.newThread(()->{
//            System.out.println(111);
//        });
//        System.out.println(thread.toString());


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,100,
                10,TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(10),
                new MyThreadFactory("test"), new ThreadPoolExecutor.DiscardOldestPolicy());


        /**
         * 没有返回值得执行
         */
        for(int i = 0; i < 100; i++){
            threadPoolExecutor.execute(()->{
//                System.out.println(atomicInteger.incrementAndGet());
                synchronized (new Object()){
                    System.out.println(a++);
                }

            });
        }



//        for (int i = 0; i < 100; i++){
//            Future<?> future = threadPoolExecutor.submit(() -> {
//                System.out.println();
//                return len++;
//
//            });
//            try {
//                Object obj = future.get();
//                System.out.println(obj);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                //处理中断异常
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//                //处理执行异常
//            }finally {
//                //关闭线程池
////                threadPoolExecutor.shutdown();
////                threadPoolExecutor.shutdownNow();
////                threadPoolExecutor.isShutdown();
//            }
//
//        }

    }

    /**
     *   处理器名称：	Intel Core i7
     *   处理器速度：	2.2 GHz
     *   处理器数目：	1
     *   核总数：	6
     *   L2 缓存（每个核）：	256 KB
     *   L3 缓存：	9 MB
     *   内存：	16 GB
     *
     *
     *   实际打印为12核
     */
    @Test
    public void test02(){
        //cpu
        System.out.println("cpu颗数：" + Runtime.getRuntime().availableProcessors());
    }

    /**
     *
     */
    @Test
    public void test03(){

//        for(int i = 0; i < 10000; i++){
//            new Thread(()->{
//                synchronized (new Object()){
//                    System.out.println(a++);
//                }
//            }).start();
//        }


//        for(int i = 0; i < 1000; i++){
//            new Thread(()->{
//                synchronized (this){
//                    System.out.println(a++);
//                }
//            }).start();
//        }


        for(int i = 0; i < 1000; i++){
            new Thread(()->{
                try {
                    a++;
                    System.out.println(a);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }


    /**
     *
     */
    @Test
    public void test04(){
        for(int i = 0; i < 100; i++){
            new Thread(()->{
                try {
//                    System.out.println(Thread.currentThread().toString());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a++;
                System.out.println(a);

//                synchronized (this){
//                    System.out.println(a++);
//                }

            }).start();
        }
    }



    @Test
    public void test05(){
        for(int i = 0; i < 1000; i++){
            new Thread(()->{
                a++;
                System.out.println(a);
                try {
//                    System.out.println(Thread.currentThread().toString());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }




}
