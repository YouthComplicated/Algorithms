package thread.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: nj
 * @date: 2020-02-05 12:56
 * @version: 0.0.1
 */
public class AtomicAba {


    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);


    public static void main(String[] args) {
        /**
         * ABA问题
         */
//        new Thread(()->{
//            atomicReference.compareAndSet(100,101);
//            atomicReference.compareAndSet(101,100);
//        },"t1").start();
//
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            atomicReference.compareAndSet(100,4444);
//            System.out.println(atomicReference.get());
//        },"t2").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第 1 次版本号"+stamp+" \t值" + stampedReference.getReference());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t 第 2 次版本号"+stampedReference.getStamp()+" \t值" + stampedReference.getReference());
            stampedReference.compareAndSet( 101 , 100 ,stampedReference.getStamp(),stampedReference.getStamp()+ 1 );
            System.out.println(Thread.currentThread().getName()+"\t 第 3 次版本号"+stampedReference.getStamp()+" \t值" + stampedReference.getReference());
        }, "t3").start();


        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第 1 次版本号"+stamp+" \t值" + stampedReference.getReference());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = stampedReference.compareAndSet(100, 199, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+ "\t 修改成功否 " +result+ " \t 最新版本号 " +stampedReference.getStamp());
            System.out.println( " 最新的值 \t " +stampedReference.getReference());
        }, "t5").start();


        System.out.println("线程颗数："+Runtime.getRuntime().availableProcessors());


    }
}