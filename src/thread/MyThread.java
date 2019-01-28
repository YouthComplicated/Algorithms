package thread;



class TestThread implements  Runnable{
    @Override
    public synchronized void  run() {
        while (true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=========自定义线程启动==========");
        }
    }
}
public class MyThread {
    public static void main(String[] args) {

        TestThread testThread = new TestThread();

        //创建线程,并指定线程任务
        Thread thread = new Thread(testThread);
        thread.start();

        while(true) {
            synchronized (testThread) {
                System.out.println("主线程执行了...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testThread.notifyAll();
            }
        }



        /**
         * Exception in thread "thread-0" java.lang.IllegalMonitorStateException
         * 	at java.lang.Object.wait(Native Method)
         */
//        while (true){
//            System.out.println("===主线程启动===");
//            try {
//                thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
