package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReturnThread  implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("=====开始计算====");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ReturnThread returnThread = new ReturnThread();
        FutureTask<Integer> task = new FutureTask<>(returnThread);

        Thread t = new Thread(task);
        t.start();

        System.out.println(22222222);
        Integer result = task.get();
        System.out.println("线程的结果为："+result);

    }


}
