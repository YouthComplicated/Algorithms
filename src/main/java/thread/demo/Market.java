package thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 *
 * 模拟超市购物排队场景(100人 结算窗口3个)
 *
 * @author: nj
 * @date: 2020-02-04 12:35
 * @version: 0.0.1
 */
public class Market {


    /**
     * 建模
     *
     * 生产消费场景:
     * 第一种思路：
     * 排队人员为消费者  结算窗口为资源提供者(3个)
     *
     * 100个人==》100 threads
     * 窗口资源3个
     * 同一时刻并发数为3
     * 应用场景: 1、限流 2、资源的访问限制
     *
     *
     * 第二种思路:
     * 排队人员为资源提供者 结算窗口为消费者
     *
     */
    class SemaphoreRunnable implements Runnable {
        /**
         * 信号量
         */
        private Semaphore semaphore;
        /**
         * 记录第几个用户
         */
        private int user;

        public SemaphoreRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }
        @Override
        public void run() {
            try {
                //获取信号量许可
                semaphore.acquire();
                System.out.println("用户"+ user +"进入窗口，准备买票");
                Thread.sleep((long)(Math.random()*10000));
                System.out.println("用户"+ user +"买票完成，即将离开");
                Thread.sleep((long)(Math.random()*10000));
                System.out.println("用户"+ user +"离开窗口");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void execute(){
        //定义窗口个数
        final Semaphore semaphore = new Semaphore(3);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟20个用户买票
        for(int i = 0; i < 20 ;i ++) {
            //去买票
            threadPool.execute(new SemaphoreRunnable(semaphore,(i+1)));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        Market semaphoreDemo = new Market();
        semaphoreDemo.execute();

    }







}