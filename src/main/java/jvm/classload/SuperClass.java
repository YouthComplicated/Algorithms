package jvm.classload;

public class SuperClass {
    static {
        System.out.println("SuperClass（父类）被初始化了。。。");
    }
    public static int value = 66;
}