package thread.multithreadcommunication;

/**
 *
 * 保证线程有序执行 线程顺序的绑定 有耦合关系
 * 如何做到没有耦合关系
 *
 * @author: nj
 * @date: 2020-03-30 17:08
 * @version: 0.0.1
 */
public class JoinABC {

    private void a(){
        System.out.println("方法a执行....");
    }

    private void b(Thread a){
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法b执行....");
    }
    private void c(Thread b){
        try {
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法c执行....");
    }

    public static void main(String[] args) {

        JoinABC joinABC = new JoinABC();

        Thread a = new Thread(() -> {
            joinABC.a();
        });

        Thread b = new Thread(() -> {
            joinABC.b(a);
        });

        Thread c = new Thread(() -> {
            joinABC.c(b);
        });

        c.start();
        b.start();
        a.start();

    }

}