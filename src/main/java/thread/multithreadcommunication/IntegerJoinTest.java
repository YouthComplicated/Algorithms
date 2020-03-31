package thread.multithreadcommunication;

import org.junit.Test;


/**
 * join的错误用法
 */
public class IntegerJoinTest {

    static Integer i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for(int k=0; k < 100000; k++){
                synchronized(i){
                    i++;
                }
            }
        }
    }

    public static class AddThread1 extends Thread{
        @Override
        public void run(){
            synchronized (i){
                for(int k=0; k < 100000; k++){
                    i++;
                }
            }
        }
    }

    @Test
    public void test01() throws InterruptedException {
        AddThread t1 = new AddThread();
        AddThread t2=new AddThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(3000);
        System.out.println(i);
    }

    @Test
    public void test02() throws InterruptedException {
        AddThread1 t1 = new AddThread1();
        AddThread1 t2=new AddThread1();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(3000);
        System.out.println(i);
    }

}
