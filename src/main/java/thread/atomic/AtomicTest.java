package thread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.*;

/**
 *
 * 原子类操作：
 * 原子更新基本类型(没有byte,short,float,char)
 *      AtomicBoolean AtomicInteger AtomicLong
 *
 * 原子更新数组
 *      AtomicIntegerArray  AtomicXXXArray
 *
 * 原子更新抽象类型
 *      AtomicReference
 *
 * 原子更新字段
 *     AtomicIntegerFiledUpdater
 *
 *     AtomicXXX
 *     AtomicXXXArray
 *     AtomicXXXFieldUpdater
 *
 * 时间戳
 *     AtomicStampedReference
 *
 * 特殊 DoubleAccumulator DoubleAdder  LongXXX LongXXX  Striped64
 *
 *     AtomicMarkableReference 是否更改过 boolean
 *
 * 底层cas
 */
public class AtomicTest {

    private int value;

    private AtomicInteger atoValue = new AtomicInteger(0);

    private int []  array = {1,2,3};

    private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    /**
     * 引用类型，更新实例化对象引用
     */
    private AtomicReference<User> atomicReference = new AtomicReference<>();

    AtomicIntegerFieldUpdater<User> updater =  AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    static AtomicReference<Integer> atomicRef = new AtomicReference<>();

    public int getNext(){
        atomicIntegerArray.addAndGet(2,3);
        atomicIntegerArray.getAndAdd(1,2);

        User user = new User("张珊",1);
        System.out.println(updater.getAndIncrement(user));
        System.out.println(updater.getAndIncrement(user));
        System.out.println(updater.getAndIncrement(user));
        return atoValue.getAndIncrement();
    }


    /**
     * 时间戳维度控制过程
     * @param args
     */


    public static void main(String[] args) {

//        System.out.println(user.getAndIncrement(user));
//        System.out.println(user.getAndIncrement(user));


        AtomicTest s = new AtomicTest();
//		while(true) {
//			System.out.println(s.getNext());
//		}


//        new Thread(()->{
//            while(true) {
//                System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


//        new thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    System.out.println(thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    System.out.println(thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();



        User user = new User("张三", 12);
        AtomicMarkableReference<User> markRef = new AtomicMarkableReference<>(user, false);
        User updateUser = new User("张三",23);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"：初始值：" +
                   user+ "初始标记："+ false );
            if(markRef.compareAndSet(user,updateUser,markRef.isMarked(),Boolean.TRUE)){
                System.out.println("A修改成功！成功之后的值："+ markRef.getReference());
            }else{
                System.out.println("B修改失败！");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        User user1 = new User("张三", 12);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：初始值：" +
                    markRef.getReference()+ "初始标记："+ markRef.isMarked() );
            markRef.compareAndSet(markRef.getReference(),user1,markRef.isMarked(), Boolean.TRUE);
            System.out.println(Thread.currentThread().getName()+"：修改之后的值：" +markRef.getReference()+"初始标记："+ markRef.isMarked());
        },"B").start();





    }
}


class  User{

    private String name;
    /**
     * if this field is private  error:
     * Caused by: java.lang.IllegalAccessException: Class thread.atomic.AtomicTest can not access a member of class
     * thread.atomic.User with modifiers "private"
     */

//    private Integer age;

    public volatile  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
