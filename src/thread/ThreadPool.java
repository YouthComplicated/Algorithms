package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用案例
 * @author NJ
 * @date 2019/1/28 11:58
 * @return
 */
public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        pool.shutdown();
    }
}
