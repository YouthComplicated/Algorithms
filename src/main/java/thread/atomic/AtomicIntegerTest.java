package thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nj
 * @date: 2020-02-04 19:57
 * @version: 0.0.1
 */
public class AtomicIntegerTest {





    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(3);
        System.out.println(atomicInteger.compareAndSet(3,23));
        System.out.println(atomicInteger.compareAndSet(3,24));
        atomicInteger.getAndIncrement();


    }
}