package thread.atomic;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * 测试伪共享
 * @author: nj
 * @date: 2020-03-24 20:50
 * @version: 0.0.1
 */
public class TestContended {

    private static int NCPU = Runtime.getRuntime().availableProcessors();
    private static ForkJoinPool POOL = new ForkJoinPool(NCPU);
    private static int INCREMENT_PER_TASK = 1000000;
    private static final int REPEAT = 10;

    private static long l = 0;

    private static long l1 = 0;
    private static long l2 = 0;

    private static long cl1 = 0;
    private static volatile long q0, q1, q2, q3, q4, q5, q6;
    private static long cl2 = 0;

    /**
     * 从上往下依次为：1）单线程累加一个long；2）两个线程累加一个long；
     *              3）两个线程累加两个long，这两个long位于同一缓存行中；
     *              4）两个线程累加两个long，且它们位于不同缓存行中。
     * @param args
     */
    public static void main(String[] args) {
        repeatWithStatics(REPEAT, () -> testLongWithSingleThread());
        repeatWithStatics(REPEAT, () -> testLong());
        repeatWithStatics(REPEAT, () -> testTwoLong());
        repeatWithStatics(REPEAT, () -> testTwoContendedLong());
    }

    public static void testLongWithSingleThread() {
        repeat(2 * INCREMENT_PER_TASK, () -> l++);
    }

    public static void testLong() {
        asyncExecute2Task(() -> repeat(INCREMENT_PER_TASK, () -> l++), () -> repeat(INCREMENT_PER_TASK, () -> l++));
    }

    public static void testTwoLong() {
        asyncExecute2Task(() -> repeat(INCREMENT_PER_TASK, () -> l1++), () -> repeat(INCREMENT_PER_TASK, () -> l2++));
    }

    public static void testTwoContendedLong() {
        asyncExecute2Task(() -> repeat(INCREMENT_PER_TASK, () -> cl1++), () -> repeat(INCREMENT_PER_TASK, () -> cl2++));
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

    private static void asyncExecute2Task(Runnable task1, Runnable task2) {
        try {
            CompletableFuture.runAsync(task1, POOL)
                    .thenCombine(CompletableFuture.runAsync(task2, POOL), (r1, r2) -> 0).get();
        } catch (Exception e) {}
    }

    private static void repeat(int n, Runnable runnable) {
        ntimes(n).forEach(x -> runnable.run());
    }

    private static IntStream ntimes(int n) {
        return IntStream.range(0, n);
    }
}