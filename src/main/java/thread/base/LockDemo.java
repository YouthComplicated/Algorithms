package thread.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable
{
    public synchronized void sendEmail()throws Exception
    {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendEmail");
        sendSMS();
    }
    public synchronized void sendSMS()throws Exception
    {
        System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****sendSMS");
    }


    public void sayHello()throws Exception
    {
        System.out.println("*****sayHello");
    }



    //lock
    Lock lock = new ReentrantLock();
    public  void get(){
        lock.lock();
        try{
            System.out.println("ThreadName:"+Thread.currentThread().getName()+":*****invoke-get");
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
 * @auther zzyy
 *  8 lock
 *1 标准访问，请问先打印邮件还是短信
 *2 暂停4秒钟在邮件方法，请问先打印邮件还是短信
 *3 新增普通sayHello方法，请问先打印邮件还是hello
 *4 两部手机，请问先打印邮件还是短信
 *5 两个静态同步方法，同一部手机，请问先打印邮件还是短信
 *6 两个静态同步方法，2部手机，请问先打印邮件还是短信
 *7 1个静态同步方法，1个普通同步方法,同一部手机，请问先打印邮件还是短信
 *8 1个静态同步方法，1个普通同步方法,2部手机，请问先打印邮件还是短信
 *
 */
public class LockDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try
            {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try
            {
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


        Phone phone3 = new Phone();
        Thread c = new Thread(phone3);
        Thread d = new Thread(phone3);
        c.start();
        d.start();

    }
}







