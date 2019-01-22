package Thread.Condition;

/**
 * 顺序执行a,b,c
 */
public class Demo {

    private int signal;

    public synchronized void a() {
        while(signal != 0 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal ++;
        notifyAll();
    }

    public synchronized void b() {
        while(signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal ++;
        notifyAll();
    }

    public synchronized void c () {
        while(signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("c");
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
        while (true){
            demo.a();
//            System.out.println("调用A方法....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class C implements Runnable{

    private Demo demo;

    public C(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true){
            demo.c();
//            System.out.println("调用C方法....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class B implements Runnable{

    private Demo demo;

    public B(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true){
            demo.b();
//            System.out.println("调用B方法....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
