package jdk.jdk8.lambaTest.FunctionInterfaceTest;

public interface interfaceTest {
    /**
     * 继承抽象类同时实现接口引发的问题
     * 如果一个类实现了某个拥有default方法的接口的话，在该类中则不需要自己再次实现该default方法了。
     * 但是如果该类实现接口时，还继承了某个抽象类，该抽象类拥有一个和default签名一样的抽象方法，则在该类中必须重写抽象方法(也是接口中的该default方法)：
     *
     */

    default void getColorA(){
        System.out.println("interface - getColorA--------");
    }


}
