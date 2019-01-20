package Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子类操作：
 * 原子更新基本类型
 * 原子更新数组
 * 原子更新抽象类型
 * 原子更新字段
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


    public int getNext(){
        atomicIntegerArray.addAndGet(2,3);
        atomicIntegerArray.getAndAdd(1,2);

        User user = new User("张珊",1);
        System.out.println(updater.getAndIncrement(user));
        System.out.println(updater.getAndIncrement(user));
        System.out.println(updater.getAndIncrement(user));
        return atoValue.getAndIncrement();
    }


    public static void main(String[] args) {

//        System.out.println(user.getAndIncrement(user));
//        System.out.println(user.getAndIncrement(user));


        AtomicTest s = new AtomicTest();
//		while(true) {
//			System.out.println(s.getNext());
//		}

        new Thread(()->{
            while(true) {
                System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


    }
}
class  User{

    private String name;
    /**
     * if this field is private  error:
     * Caused by: java.lang.IllegalAccessException: Class Thread.Atomic.AtomicTest can not access a member of class Thread.Atomic.User with modifiers "private"
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
