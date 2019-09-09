package jdk.jdk8.lambaTest.FunctionInterfaceTest;

public class functionalInterfaceTest {

    public static void main(String[] args) {
        Consumber c = new Consumber() {
            @Override
            public void apply(int i) {
                System.out.println(i);
            }
        };

        c.apply(44444);

        Consumber b = new Consumber() {
            @Override
            public void apply(int i) {
                System.out.println("aaaa");
            }
        };

        b.apply(222);

        //lambda
        Consumber v = param -> System.out.println(param);
        v.apply(555);

        System.out.println("-------------");

        Provider provider = (i) -> System.out.println(i);
        provider.toProvider(111);

    }


    @FunctionalInterface
    interface  Consumber{
        void apply(int i);
    }



    //符合函数式接口，不强制加注解@FunctionalInterface也可以
    interface Provider{
        void toProvider(int i);

//        void aa();

    }
}
