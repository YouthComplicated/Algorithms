package jdk.serialization.serial;

import org.junit.Test;

import java.io.*;

public class TestSer {


    /**
     *
     * 实例化的对象没有实现serializable接口会抛出异常：
     *
     * java.io.NotSerializableException: jdk.serialization.serial.Dog
     *
     *
     * 1、序列化时，只对对象的状态进行保存，而不管对象的方法；
     * 2、当一个父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口；
     * 3、当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化；
     * 4、并非所有的对象都可以序列化，,至于为什么不可以，有很多原因了,比如：
     *  >> 安全方面的原因，比如一个对象拥有private，public等field，对于一个要传输的对象，比如写到文件，
     *      或者进行rmi传输  等等，在序列化进行传输的过程中，这个对象的private等域是不受保护的。
     *  >> 资源分配方面的原因，比如socket，thread类，如果可以序列化，进行传输或者保存，
     *      也无法对他们进行重新的资源分配，而且也是没有必要这样实现。
     *
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        Dog dog = new Dog(10,1);
        FileOutputStream fs = new FileOutputStream("foo.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(dog);
        os.close();

    }

    /**
     * 父类实现序列化，子类自动实现序列化
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        Cat cat = new Cat("tomscott", 23);
        FileOutputStream fs = new FileOutputStream("cat.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(cat);
        os.close();

    }

    /**
     * 当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化；
     *
     * 如包含嵌套结构，也进行序列化
     *
     * 前提条件是该引用的对象也实现了序列化接口
     *
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        Bird bird = new Bird("liuliu",12);
        Cat cat = new Cat(bird,"tomscott", 23);
        FileOutputStream fs = new FileOutputStream("cat1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(cat);
        os.close();

    }


    /**
     *
     * 如果读取时候类与写入的类不一致会产生什么效果
     *
     *
     * 属性的增加和减少 导致什么问题？？
     *
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void test04() throws IOException, ClassNotFoundException {

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("cat1.ser"));
        Object cat = is.readObject();
        System.out.println(cat);
        is.close();

    }


    /**
     *
     * 测试writeObject...  方法名必需相同
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void test05() throws IOException, ClassNotFoundException {
        Dog dog = new Dog("小猫", 12,89);
        FileOutputStream fs = new FileOutputStream("dog.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(dog);
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("dog.ser"));
        Object dog1 = is.readObject();
        System.out.println(dog1);
        is.close();

    }





}
