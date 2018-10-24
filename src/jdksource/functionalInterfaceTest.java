package jdksource;

public class functionalInterfaceTest {

    public static void main(String[] args) {
        consumber c = new consumber() {
            @Override
            public void apply(int i) {
                System.out.println(i);
            }
        };
        c.apply(44444);

        consumber b = new consumber() {
            @Override
            public void apply(int i) {
                System.out.println("aaaa");
            }
        };
        b.apply(222);

        //lambda
        consumber v = param -> System.out.println(param);
        v.apply(555);


    }


    @FunctionalInterface
    interface  consumber{
        void apply(int i);
    }
}
