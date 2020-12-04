package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

/**
 * @author: nj
 * @date: 2020-10-30 20:49
 * @version: 0.0.1
 */
public class TestA {


//    Condition conditionA = new Condition()

    public static void main(String[] args) throws InterruptedException {




//        for (int i = 0; i < 10; i++) {
//            ThreadA threadA = new ThreadA();
//            ThreadB threadB = new ThreadB();
//            ThreadC threadC = new ThreadC();
//            threadA.start();
//            threadA.join();
//            threadB.start();
//            threadB.join();
//            threadC.start();
//        }

        PrintABCUsingSemaphore testA = new PrintABCUsingSemaphore();

        new Thread(() -> testA.printA()).start();
        new Thread(() -> testA.printB()).start();
        new Thread(() -> testA.printC()).start();



    }


}

class PrintABCUsingSemaphore {

    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);
    //private int attempts = 0;


    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 0; i < 10; ) {
            try {
                currentSemaphore.acquire();
                //System.out.println(Thread.currentThread().getName()+" try to print "+name+", attempts : "+(++attempts));
                System.out.println(Thread.currentThread().getName() +" print "+ name);
                i++;
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class ThreadA extends Thread{

    @Override
    public void run() {
        System.out.println("ThreadA");

    }
}

class ThreadB extends Thread{

    @Override
    public void run() {
        System.out.println("ThreadB");
    }
}

class ThreadC extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadC");
    }
}

