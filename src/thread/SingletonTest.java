package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 恶汉式
 */
class Singleton01 {
    private Singleton01(){}

    private static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance(){
        return instance;
    }
}

/**
 * 懒汉式操作
 *
 * 偏向锁
 * 轻量级锁
 */
class Singleton02 {
    private Singleton02(){}

    /**
     * volatile 防止虚拟机一些优化
     */
    private static volatile  Singleton02 singeleton ;

    public static synchronized Singleton02 getInstance(){
        //自旋 while true
        if(singeleton == null){
//            try {
//                thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Singleton02.class){
                //如何模拟该程序的产生
                if(singeleton == null){
                    //指令重排序
                    singeleton = new Singleton02();

                    // 申请内存空间
                    // 在空间地址实例化对象
                    // instance 的引用指向空间地址
                }
            }
        }
        return singeleton;
    }


}



public class SingletonTest {
    public static void main(String[] args) {

//        Singleton01 singeleton1 = Singleton01.getInstance();
//        Singleton01 singeleton2 = Singleton01.getInstance();
//        System.out.println(singeleton1);
//        System.out.println(singeleton2);

        ExecutorService pool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++){
            pool.execute(()->{
                System.out.println(Singleton02.getInstance());
            });
        }
        pool.shutdown();

    }
}
