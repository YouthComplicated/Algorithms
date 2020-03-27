package thread.locktype;


/**
 * 可重入锁
 */
public class ReentryLock {


    public synchronized void a(){
        System.out.println("a");
//        b();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("离开方法a()...");
    }

    public synchronized void b(){
        System.out.println("b");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("离开方法b()...");
    }


    public static void main(String[] args) {
        /**
         * 不同对象，不同锁 ，互不干涉
         */
        ReentryLock lock1 = new ReentryLock();
        ReentryLock lock2 = new ReentryLock();
        new Thread(()-> lock1.a()).start();
        new Thread(()->lock2.b()).start();

//        ReentryLock lock3 = new ReentryLock();
//        new Thread(()->lock3.a()).start();
//        new Thread(()->lock3.b()).start();

    }
}
