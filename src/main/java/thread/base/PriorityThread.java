package thread.base;


class PriThread extends Thread{

    private String name;

    public PriThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+this.name);
        }
    }
}

public class PriorityThread {

    public static void main(String[] args) {
        PriThread priThread1 = new PriThread("--------1");
        PriThread priThread2 = new PriThread("--------2");
        PriThread priThread3 = new PriThread("--------3");
        PriThread priThread4 = new PriThread("--------4");

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
