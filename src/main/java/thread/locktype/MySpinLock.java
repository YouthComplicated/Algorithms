package thread.locktype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * 自旋锁
 *
 *
 * 自旋锁的优点：
 * 自旋锁不会使线程状态发生切换，一直处于用户态，即线程一直都是active的；不会使线程进入阻塞状态，减少了不必要的上下文切换，执行速度快
 * 非自旋锁在获取不到锁的时候会进入阻塞状态，从而进入内核态，当获取到锁的时候需要从内核态恢复，需要线程上下文切换。
 * （线程被阻塞后便进入内核（Linux）调度状态，这个会导致系统在用户态与内核态之间来回切换，严重影响锁的性能
 *
 * 缺点：
 * 如果某个线程持有锁的时间过长，就会导致其它等待获取锁的线程进入循环等待，消耗CPU。使用不当会造成CPU使用率极高。
 *
 *
 * 问题：能否实现公平的自旋锁
 *      实现可重入的自旋锁
 *
 * 以下是不可重入锁实现
 *
 * @author: nj
 * @date: 2020-02-05 16:14
 * @version: 0.0.1
 */
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void lock(){
        Thread thread = Thread.currentThread();
        System.out.println("lock-"+thread.getName()+"-reference:" + atomicReference.get());
        while (!atomicReference.compareAndSet(null, thread)){
            System.out.println("lock-"+thread.getName()+"-111");
        }
        System.out.println("lock-reference:" + atomicReference.get());
    }


    private void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println("unlock-"+thread.getName()+"-reference:" + atomicReference.get());
        while (!atomicReference.compareAndSet(thread, null)){
            System.out.println("unlock-"+thread.getName()+"-222");
        }
    }

    public static void main(String[] args) {

//        test01();

        /**
         * 测试不可重入锁
         */
//        test02();

        /**
         * 测试可重入锁
         */
        test03();

    }


    /**
     *
     * 验证该设计不是可重入锁
     *
     * 当一个线程第一次已经获取到了该锁，在锁释放之前又一次重新获取该锁，第二次就不能成功获取到。由于不满足CAS，所以第二次获取会进入while循环等待，
     * 而如果是可重入锁，第二次也是应该能够成功获取到的。而且，即使第二次能够成功获取，那么当第一次释放锁的时候，第二次获取到的锁也会被释放，而这是不合理的。
     *
     */
    public static void test02(){
        MySpinLock spinLock = new MySpinLock();
        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println("第一次获取锁之后执行代码....");
                TimeUnit.SECONDS.sleep(1);
                spinLock.lock();
                try{
                    System.out.println("第二次获取锁之后执行代码....");
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    spinLock.unlock();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"CC").start();
    }

    /**
     * 测试ReentrantSpinLock  可重入自选锁
     */
    public static void test03(){
        ReentrantSpinLock spinLock = new ReentrantSpinLock();
        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println("第一次获取锁之后执行代码....");
                TimeUnit.SECONDS.sleep(1);
                spinLock.lock();
                try{
                    System.out.println("第二次获取锁之后执行代码....");
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    spinLock.unlock();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"CC").start();


    }


    /**
     * 简单描述一下过程：
     *
     * AA 线程优先于 BB 线程 执行lock(), 将atomicReference 赋值，之后sleep
     *
     * 在sleep过程中 BB 线程 执行lock(),但因为atomicReference不为null,一直cpu 空转
     *
     * 直到 AA 睡醒之后中执行unlock方法之后,将atomicReference 置为null,此时 BB线程才能执行
     *
     */
    public static void test01(){
        MySpinLock spinLock = new MySpinLock();
        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in");
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"AA").start();

        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"BB").start();

        new Thread(()->{
            spinLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+":come in");
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"CC").start();
    }

    /**
     * lock
     */
    public static void print(){
        MySpinLock spinLock = new MySpinLock();
        spinLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+":come in");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            spinLock.unlock();
        }
    }

}


