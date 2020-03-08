package thread.tool;

import java.util.concurrent.TimeUnit;

/**
 *
 * 测试死锁
 * @author: nj
 * @date: 2020-02-07 16:02
 * @version: 0.0.1
 */


class DeadLock implements Runnable{
    private String a = "aaaa";
    private String b = "bbbb";

    public DeadLock(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a){
            try {
                System.out.println("获取锁a");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println("获取锁b");
            }
        }
    }
}
public class MyDeadLock {


    public static void main(String[] args) {
       new Thread(new DeadLock("lockA","lockB")).start();
       new Thread(new DeadLock("lockB","lockA")).start();

    }
}