package thread.base;




class ProducerThread extends Thread {

//    @Override
//    public void run(){
//        System.out.println();
//    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("线程开始....");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class SuspendTest {


    public static void main(String[] args) {

        ProducerThread thread1 = new ProducerThread();
        thread1.start();
        thread1.suspend();
        try {
            Thread.sleep(3000);
            System.out.println("暂停。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        thread1.resume();


    }
}
