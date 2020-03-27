package thread.locktype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {


    public synchronized void sendEmail()throws Exception {
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendEmail");
        TimeUnit.SECONDS.sleep(4);
        sendSMS();
    }

    public synchronized void sendSMS()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
    }


    public synchronized void sendBye()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
        //synchronized 代码块中包含非同步代码会出现什么情况
        TimeUnit.SECONDS.sleep(4);
        sayHello();
    }

    public void sayHello()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sayHello");
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     *  以下为静态同步方法
     */
    public static synchronized void sendEmail1()throws Exception {
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendEmail");
        TimeUnit.SECONDS.sleep(4);
        sendSMS1();
    }

    public static synchronized void sendSMS1()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
    }


    /**
     * 静态同步方法不能调用非静态方法
     */
    public static synchronized void sendEmail2()throws Exception {
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendEmail");
        TimeUnit.SECONDS.sleep(4);
//        sendSMS2();
    }

    public synchronized void sendSMS2()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
    }


    /**
     *
     * 普通同步方法调用静态方法  可以
     */
    public synchronized void sendEmail3()throws Exception {
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendEmail");
        TimeUnit.SECONDS.sleep(4);
        sendSMS3();
    }

    public static synchronized void sendSMS3()throws Exception {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
    }



    /**
     * lock
     */
    Lock lock = new ReentrantLock();
    public  void get(){
        lock.lock();
        try{
            System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****invoke-get");
            TimeUnit.SECONDS.sleep(3);
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public void set(){
        lock.lock();
        try{
            System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****invoke-set");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
       get();
    }
}


/**
 *  8 lock
 *
 *1 标准访问，请问先打印邮件还是短信
 *
 *2 暂停4秒钟在邮件方法，请问先打印邮件还是短信
 *
 *3 新增普通sayHello方法，请问先打印邮件还是hello
 *
 *4 两部手机，请问先打印邮件还是短信
 *
 *5 两个静态同步方法，同一部手机，请问先打印邮件还是短信
 *
 *6 两个静态同步方法，2部手机，请问先打印邮件还是短信
 *
 *7 1个静态同步方法，1个普通同步方法,同一部手机，请问先打印邮件还是短信
 *
 *8 1个静态同步方法，1个普通同步方法,2部手机，请问先打印邮件还是短信
 *
 */
public class TestSynchronizeDemo {



    public static void main(String[] args) throws InterruptedException {

        /**
         *
         * 1 标准访问，请问先打印邮件还是短信  先执行邮件，之后短信
         * 2 暂停4秒钟在邮件方法，请问先打印邮件还是短信
         * 5 两个同步方法，同一部手机，请问先打印邮件还是短信
         *
         * 先打印邮件，一旦线程获得sendEmail锁，方法中调用sendSMS() 会持有锁，只有等待该线程执行完成之后
         * 其它线程才能抢占sendSMS(),同一个对象
         *
         */
//        test01();


        /**
         *
         * 3 新增普通sayHello方法，请问先打印邮件还是hello
         *
         * 7 1个静态同步方法，1个普通同步方法,同一部手机，请问先打印邮件还是短信
         *
         *
         * 同步代码块中包含普通方法，该同步代码块中普通方法调用，不会受到外部锁的干预，
         * 换句话说，同步代码块中的普通方法不受外层synrchized 限制
         */
//        test02();


        /**
         * 不同对象 调用出现什么情况
         *
         * 4 两部手机，请问先打印邮件还是短信(普通同步方法是锁住对象，故两个对象互补干预)
         *
         * 5 两个静态同步方法，同一部手机，请问先打印邮件还是短信
         *
         * 6 两个静态同步方法，2部手机，请问先打印邮件还是短信
         *
         *
         * 静态同步方法，锁住的是类对象，与对象无关，静态同步方法的话，
         * 所有现场争夺同一把锁
         *
         */
//        test03();


        /**
         *
         *
         * 7 1个静态同步方法，1个普通同步方法,同一部手机，请问先打印邮件还是短信
         *
         * 》》静态同步方法不能调用普通同步方法 不必进行测试
         *
         * 》》普通同步方法调用静态方法 (同一个对象，不同对象等)
         *
         * 8 1个静态同步方法,1个普通同步方法,2部手机，请问先打印邮件还是短信
         *
         *
         */
//        test04();


        /**
         * 》》普通同步方法调用静态方法 (同一个对象，不同对象等)
         *
         * 锁住同一个对象
         *
         * 不同对象互不干预
         *
         */
//        test05();


        /**
         * 测试ReentrantLock 线程抢占情况 当个对象(lock 是全局)
         */
//        test06();

        /**
         * 两个不同的对象 互不干涉
         */
        test07();







    }



    public static void test01(){
        Phone phone = new Phone();
        new Thread(() -> {
            try
            {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(() -> {
            try
            {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

    public static void test02(){
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

        new Thread(()->{
            try {
                phone.sendBye();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        
        new Thread(()->{
            try {
                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }


    public static void test03(){
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone1.sendEmail1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                phone1.sendEmail1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


        new Thread(()->{
            try {
                phone2.sendEmail1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }


    public static void test04(){
        Phone phone1 = new Phone();

        new Thread(()->{
            try {
                phone1.sendEmail2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();


//        new Thread(()->{
//            try {
//                phone1.sendEmail1();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"B").start();

    }

    public static void test05(){

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone1.sendEmail3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(()->{
            try {
                phone1.sendEmail3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


        new Thread(()->{
            try {
                phone2.sendEmail3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }


    public static void test06(){
        Phone phone3 = new Phone();
        Thread c = new Thread(phone3);
        Thread d = new Thread(phone3);
        c.start();
        d.start();
    }

    public static void test07(){
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Thread t1 = new Thread(phone1);
        Thread t2 = new Thread(phone2);
        t1.start();
        t2.start();
    }


}






