package Thread;


class PriThread extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class PriorityThread {

    public static void main(String[] args) {
        PriThread priThread1 = new PriThread();
        PriThread priThread2 = new PriThread();
        PriThread priThread3 = new PriThread();
        PriThread priThread4 = new PriThread();

        priThread1.setPriority(Thread.MIN_PRIORITY);
        priThread2.setPriority(Thread.MIN_PRIORITY);
        priThread3.setPriority(Thread.MIN_PRIORITY);
        priThread4.setPriority(Thread.MAX_PRIORITY);


        priThread1.start();
        priThread2.start();
        priThread3.start();
        priThread4.start();


    }

}
