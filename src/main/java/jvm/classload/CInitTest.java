package jvm.classload;

public class CInitTest {

    static class Parent{

        /**
         * 非法前向引用
         */
//        static {
//            System.out.println("A:"+ A);
//            A = 2;
//        }

        public static int A = 1;

        static {
            System.out.println("A:"+ A);
            A = 2;
        }

    }

    static class Sub extends Parent{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);

//        int a;
//        System.out.println(a);
    }
}
