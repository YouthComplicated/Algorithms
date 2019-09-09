package jdk.jdk8.lambaTest;


@FunctionalInterface
interface MyInterface {

    // only one abstract method
    void test();

    //override Object method not count toward the interface's abstract method count
    String toString();
}

public class Test2 {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();


        test2.myTest(() -> {
            System.out.println("mytest");
        });

        System.out.println("----------");

        // interface's instance
        MyInterface myInterface = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

        System.out.println("=================");
        System.out.println(myInterface.getClass().getInterfaces());
        System.out.println(myInterface.getClass().getAnnotatedSuperclass());
        System.out.println(myInterface.getClass().getAnnotations());
        System.out.println(myInterface.getClass().getAnnotatedInterfaces());
    }
}
