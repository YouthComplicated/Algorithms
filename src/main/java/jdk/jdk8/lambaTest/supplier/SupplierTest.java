package jdk.jdk8.lambaTest.supplier;


import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());
    }
}
