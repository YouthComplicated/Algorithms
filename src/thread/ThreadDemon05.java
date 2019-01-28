package thread;


class CreateThread extends Thread{

    public CreateThread(String name){
        super(name);
    }

    @Override
    public void run() {
        int i = 0;

//        while (true){
//            System.out.println(getName()+"线程启动"+i++);
//            try {
//                thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while (!interrupted()){
            System.out.println(getName()+"线程启动"+i++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class ThreadDemon05 {

    public static void main(String[] args) {


//        CreateThread createThread1 = new CreateThread("firstThread");
//        CreateThread createThread2 = new CreateThread("secondThread");
//        createThread1.start();
//        createThread2.start();
//        createThread2.interrupt();


        /**
         * 匿名内部类
         */

        new Thread() {
            @Override
            public void run() {
                System.out.println("thread1 start ..");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 start ..");
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(1111231);
            }
        }.start();


        /**
         * java 虚拟机多态的重写run方法,子类执行
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----runnable---");
            }
        }) {
            @Override
            public void run() {
                System.out.println("-----sub---");
            }
        }.start();


    }
}
