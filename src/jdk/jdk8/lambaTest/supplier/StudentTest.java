package jdk.jdk8.lambaTest.supplier;


import java.util.function.Supplier;

public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("-------");

        //::符合 supplier  不接受参数，返回实例(无参构造实例化)
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());



    }
}
