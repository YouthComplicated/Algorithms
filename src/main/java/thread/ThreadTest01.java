package thread;

public class ThreadTest01 {

    /**
     * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
     * @param args
     */
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1开始执行。。。。");
                for(int i = 0; i < 5; i++){
                    System.out.println("线程1:"+i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2开始执行。。。。");
                for(int i = 0; i < 5; i++){
                    System.out.println("线程2:"+i);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3开始执行。。。。");
                for(int i = 0; i < 5; i++){
                    System.out.println("线程3:"+i);
                }
            }
        });
        thread2.start();
        thread3.start();
        thread1.start();
    }
}
