package thread.tool.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: nj
 * @date: 2020-02-06 11:10
 * @version: 0.0.1
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, ()->{
            System.out.println("人到齐-开会......"); 
        });
        
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"已经到现场...");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}