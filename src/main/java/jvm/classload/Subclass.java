package jvm.classload;


public class Subclass extends SuperClass {
    static {
        System.out.println("Subclass（子类）被初始化了。。。");

    }

    public static int vv;
}