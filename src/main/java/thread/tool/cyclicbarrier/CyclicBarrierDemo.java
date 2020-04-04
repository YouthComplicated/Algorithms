package thread.tool.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 使用注意的事项
 *
 * >>CyclicBarrier一组线程相互等待，直到全部到达某个公共屏障点才继续开始工作
 * >>CyclicBarrier可以重复使用 why???
 * >>reset()
 * >>barrier.isBroken()
 *
 *
 *
 *
 *1、parties数量和调用await()次数 不一致会导致线程阻塞，线程无法释放，运维如何检测增长的无用阻塞线程
 *2、如果某一线程执行失败，失败的处理策略(all or none) 失败的原因:抛出异常，打断，超时等
 *3、如何重复使用
 *
 *
 *
 *
 * @author: nj
 * @date: 2020-02-06 11:10
 * @version: 0.0.1
 */
public class CyclicBarrierDemo {


    public static void testInterruptedException() throws InterruptedException {
        System.out.println("异常：InterruptedException");
        throw new InterruptedException();
    }

    public static void testBrokenBarrierException() throws BrokenBarrierException {
        System.out.println("异常：BrokenBarrierException");
        throw new BrokenBarrierException();
    }



    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(6, ()->{
            System.out.println("人到齐-开会......"); 
        });
        
        for (int i = 1; i <= 4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"已经到现场...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"\t"+"已经等待...");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


        /**
         * 逻辑代码抛出异常之后，barrier不会感知改异常
         */
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"已经到现场...");
            try {
//                String str = null;
//                System.out.println(str.toCharArray());

//                testInterruptedException();

//                testBrokenBarrierException();

                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
//                barrier.reset();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
//                barrier.reset();
            }
        },String.valueOf(5)).start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"已经到现场...");
            try {
//                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                String str = null;
//                System.out.println(str.toCharArray());


                System.out.println("park......");
                LockSupport.park();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("unPark......");
                LockSupport.unpark(Thread.currentThread());
                System.out.println("线程唤醒......");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
//                try {
//                    barrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
            }
        },String.valueOf(6)).start();


    }
}

