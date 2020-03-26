package thread.atomic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: nj
 * @date: 2020-03-25 08:16
 * @version: 0.0.1
 */
public class TestLongAddr {

    private static long l = 2;

    public static void main(String[] args) {
        LongAdder adder = new LongAdder();
        adder.add(l);
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.submit(()->{
                adder.increment();
            });
        }


        while (Thread.activeCount() == 2){
            service.shutdown();
            System.out.println("最终数量为："+l);
        }
    }
}