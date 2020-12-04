package thread.base;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 今日作业：编写一个类似银行、医院的叫号程序（要求：多个窗口叫号，不重号、不跳号）
 *
 * 1、银行叫号  窗口办理业务问题
 *
 * 2、
 */
public class Bank {

    private AtomicInteger number = new AtomicInteger(0);

    public  int getNumber(){
        return number.getAndIncrement();
    }


    public static void main(String[] args) {

        Bank bank = new Bank();

        ExecutorService  executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread()+""+bank.getNumber());
            });
        }
        executorService.shutdown();

    }

}
