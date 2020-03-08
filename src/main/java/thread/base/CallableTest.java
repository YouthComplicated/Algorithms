package thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: nj
 * @date: 2020-02-06 18:54
 * @version: 0.0.1
 */
public class CallableTest {


    /**
     *
     * Callable <===>Runnable  适配模式(futureTask...)
     *
     *
     * @param args
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThreadInteger());
        /**
         * 同一个futureTask不能重复使用，
         */
        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();

        Integer result = futureTask.get();

        System.out.println("运行结果:"+result);

        MyThreadInteger myThreadInteger = new MyThreadInteger();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myThreadInteger);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myThreadInteger);
        new Thread(futureTask1,"CC").start();
        new Thread(futureTask2,"DD").start();

    }
}

class MyThread1 implements Callable{
    @Override
    public Object call() throws Exception {
        return 3333;
    }
}

class MyThreadInteger implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+":come into .....");
        return 444;
    }
}