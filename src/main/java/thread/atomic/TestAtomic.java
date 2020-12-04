package thread.atomic;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: nj
 * @date: 2020-03-24 20:28
 * @version: 0.0.1
 */
public class TestAtomic {

    private static final int TASK_NUM = 1000;
    private static final int INCREMENT_PER_TASK = 10000;
    private static final int REPEAT = 10;

    private static long l = 0;

    public static void main(String[] args) throws Exception {
        repeatWithStatics(REPEAT, () -> testAtomicLong());
        repeatWithStatics(REPEAT, () -> testLongAdder());
        repeatWithStatics(REPEAT, () -> testLong());
    }


    public static void testAtomicLong() {
        AtomicLong al = new AtomicLong(0);
        execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> al.incrementAndGet()));
    }

    public static void testLong() {
        l = 0;
        execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> l++));
    }

    public static void testLongAdder() {
        LongAdder adder = new LongAdder();
        execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> adder.add(1)));
    }

    public static void repeatWithStatics(int n, Runnable runnable) {
        long[] elapseds = new long[n];
        ntimes(n).forEach(x -> {
            long start = System.currentTimeMillis();
            runnable.run();
            long end = System.currentTimeMillis();
            elapseds[x] = end - start;
        });

        System.out.printf("total: %d, %s\n", Arrays.stream(elapseds).sum(), Arrays.toString(elapseds));
    }

    /**
     * 执行
     * @param n
     * @param task
     */
    private static void execute(int n, Runnable task) {
        try {
            CountDownLatch latch = new CountDownLatch(n);
            ExecutorService service = Executors.newFixedThreadPool(100);
            Runnable taskWrapper = () -> {
                task.run();
                latch.countDown();
            };

            service.invokeAll(cloneTask(n, taskWrapper));
            latch.await();
            service.shutdown();
        } catch (Exception e) {}
    }


    /**
     * 每个线程的返回结果(callable)放入到collection中
     * @param n
     * @param task
     * @return
     */
    private static Collection<Callable<Void>> cloneTask(int n, Runnable task) {
        return ntimes(n).mapToObj(x -> new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                task.run();
                return null;
            }
        }).collect(Collectors.toList());
    }

    /**
     * 重复执行多个runnable
     * @param n
     * @param runnable
     */
    private static void repeat(int n, Runnable runnable) {
        ntimes(n).forEach(x -> runnable.run());
    }

    /**
     * 流式数据范围
     * @param n
     * @return
     */
    private static IntStream ntimes(int n) {
        return IntStream.range(0, n);
    }

}