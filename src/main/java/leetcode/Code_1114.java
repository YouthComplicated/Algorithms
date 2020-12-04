package leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nj
 * @date: 2020-11-08 22:24
 * @version: 0.0.1
 */
public class Code_1114 {


    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);


    public Code_1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (firstJobDone.get() != 1){

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }



    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);




    }







}