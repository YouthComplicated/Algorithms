package Thread.Condition;

/**
 * 顺序执行a,b,c
 * synchronized+标志位+(wait-notify)
 */
public class Demo {

    private int signal;

    public synchronized void a() {
        while(signal != 0 ) {
            System.out.println("a().......");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a"+"   signal:" + signal);
        signal ++;
        notifyAll();
    }

    public synchronized void b() {
        while(signal != 1) {
            System.out.println("b().......");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b"+"   signal:" + signal);
        signal ++;
        notifyAll();
    }

    public synchronized void c () {
        while(signal != 2) {
            System.out.println("c().......");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c"+"   signal:" + signal);
        signal = 0;
        notifyAll();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(new A(demo)).start();
        new Thread(new B(demo)).start();
        new Thread(new C(demo)).start();
    }
}
class A implements Runnable{

    private Demo demo;

    public A(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.a();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (true){
//            demo.a();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
class C implements Runnable{

    private Demo demo;

    public C(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.c();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while (true){
//            demo.c();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
class B implements Runnable{

    private Demo demo;

    public B(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.b();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while (true){
//            demo.b();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
