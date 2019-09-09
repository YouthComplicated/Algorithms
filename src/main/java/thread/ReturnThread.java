package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * (1)Callable规定的方法是call()，Runnable规定的方法是run()。其中Runnable可以提交给Thread来包装下，直接启动一个线程来执行，
 * 而Callable则一般都是提交给ExecuteService来执行。
 * (2)Callable的任务执行后可返回值，而Runnable的任务是不能返回值得
 * (3)call方法可以抛出异常，run方法不可以，内部解决
 * (4)运行Callable任务可以拿到一个Future对象，c表示异步计算的结果。
 */
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
