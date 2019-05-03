package jdk.jdk8.defaultmethod;



public class MyClass extends MyInterface1Impl implements MyInterface2{

    /**
     * 实现类方法的优先级 > 接口的方法
     * @param args
     */
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
