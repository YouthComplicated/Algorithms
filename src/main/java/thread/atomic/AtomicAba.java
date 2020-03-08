package thread.atomic;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

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


    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);




    public static void main(String[] args) {
        /**
         * ABA问题
         */
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100,4444);
            System.out.println(atomicReference.get());
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}