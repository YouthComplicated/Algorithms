package thread.base;

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
     * volatile 防止虚拟机一些优化(指令重排)
     */
//    private static volatile  Singleton02 singeleton;
    private static  Singleton02 singeleton;

    /**
     *
     * 双端校验机制
     * DCL(双端检锁) 机制不一定线程安全,原因是有指令重排的存在,加入volatile可以禁止指令重排
     *
     * 原因在于某一个线程在执行到第一次检测,读取到的instance不为null时,instance的引用对象可能没有完成初始化.
     *
     * instance=new SingletonDem(); 可以分为以下步骤(伪代码)
     *
     * memory=allocate();//1.分配对象内存空间
     *
     * instance(memory);//2.初始化对象
     *
     * instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null
     *
     * 步骤2和步骤3不存在数据依赖关系.而且无论重排前还是重排后程序执行的结果在单线程中并没有改变,因此这种重排优化是允许的.
     *
     * memory=allocate();//1.分配对象内存空间
     *
     * instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null 但对象还没有初始化完.
     *
     * instance(memory);//2.初始化对象
     *
     * 但是指令重排只会保证串行语义的执行一致性(单线程) 并不会关心多线程间的语义一致性
     *
     * 所以当一条线程访问instance不为null时,由于instance实例未必完成初始化,也就造成了线程安全问题.
     * @return
     */
    public static Singleton02 getInstance(){
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
