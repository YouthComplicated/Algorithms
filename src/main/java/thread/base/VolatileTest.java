package thread.base;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    /**
     * 1、volatile 保证可见性
     */
//    int c = 1;
    volatile int c = 1;
    public void updateCValue(){
        this.c = 1111;
    }


    /**
     * 2、不保证原子性
     */
    volatile int d = 0;
    public void addDValue(){
        d++;
    }


//    public synchronized void addDValue(){
//        d++;
//    }


    AtomicInteger f = new AtomicInteger(0);
    public  void addFValue(){
        f.getAndIncrement();
    }



    /**
     * 3、指令重排 case
     *
     */
    int a = 0;
    boolean flag = false;

    public void method01(){
        System.out.println("come into method1.....");
        a = 1;
        flag = true;

    }

    public void method02(){
        System.out.println("come into method2.....");
        if(flag){
            a += 2;
            System.out.println("method2: a:"+a);
        }

    }

    public static void main(String[] args) throws InterruptedException {


        /**
         * 1、测试可见性
         */
//        visibleVolatile();


        /**
         * 2、volatile 不保证原子性
         *
         * 如何保证原子性
         *
         * AtomicInteger  cas
         *
         */
//        atomicVolatile();

        /**
         * 3、指令重排，没有明确的案例
         */
        VolatileTest volatileTest = new VolatileTest();

        new Thread(()->{
            volatileTest.method01();

        }).start();
        new Thread(()->{
            volatileTest.method02();

        }).start();
        new Thread(()->{
            volatileTest.method02();

        }).start();



    }

    private static void atomicVolatile() throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    volatileTest.addDValue();
                    volatileTest.addFValue();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("computer is over!!!! DValue:"+volatileTest.d);
        System.out.println("computer is over!!!! FValue:"+volatileTest.f.get());
    }

    /**
     * 1、volatile 可见性测试
     */
    private static VolatileTest visibleVolatile() {
        VolatileTest volatileTest = new VolatileTest();
        System.out.println("c的value值:"+volatileTest.c);
        new Thread(() ->{
            //线程延迟相应时间
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("come into thread...");
            volatileTest.updateCValue();
            System.out.println("c value:" + volatileTest.c);
            System.out.println("离开线程....");
        }).start();

        while ( volatileTest.c == 1){
            //
        }
        System.out.println("main is over.... cValue:"+ volatileTest.c);
        return volatileTest;
    }
}



