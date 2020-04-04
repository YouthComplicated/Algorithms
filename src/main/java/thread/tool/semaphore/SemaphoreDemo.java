package thread.tool.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * 限流处理，信号量问题
 *
 *
 * @author: nj
 * @date: 2020-02-06 11:26
 * @version: 0.0.1
 */
public class SemaphoreDemo {

    /**
     * 模拟抢车位
     * @param args
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{


//                try {
//                    semaphore.acquire();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"抢到停车位子.....");
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"停车3秒离开.....");
//                semaphore.release();

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到停车位子.....");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"停车3秒离开======");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }


            },String.valueOf(i)).start();
        }


    }
}