package jdk.jdk8.methodreference;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Arrays.*;


/**
  * @Description:  方法引用
  * @Author: NJ
  * @CreateDate:2019-05-03 22:03
  * @UpdateUser:NJ
  * @UpdateDate:2019-05-03 22:03
  * @Version:1.0
*/
public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    Student student1 = new Student("zhangsan", 10);
    Student student2 = new Student("lisi", 90);
    Student student3 = new Student("wangwu", 50);
    Student student4 = new Student("zhaoliu", 40);

    List<Student> students = asList(student1, student2, student3, student4);


    /**
     * 类名::静态方法  它与  类名.静态方法 本质上有区别
     */
    @Test
    public void test01(){
//        students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));

        students.sort(Student::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        students.sort(Student::compareStudentByName);
        students.forEach(student -> System.out.println(student.getScore()));
    }

    /**
     * 实例对象名称::实例的方法名称
     */
    @Test
    public void test02(){

        StudentComparator studentComparator = new StudentComparator();

//        students.sort((studentParam1, studentParam2) ->
//                studentComparator.compareStudentByScore(studentParam1, studentParam2));

        students.sort(studentComparator::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        students.sort(studentComparator::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName()));

    }

    /**
     * 类名::实例的方法名称  场景：方法接收当前类
     */
    @Test
    public void test03(){

        students.sort(Student::compareByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        students.sort(Student::compareByName);
        students.forEach(student -> System.out.println(student.getName()));

        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
        cities.forEach(city -> System.out.println(city));
        //city1 作为第一个参数有lamba传递，city2 作为方法的参数
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);

    }

    /**
     * 构造方法引用:  类名::new
     */
    @Test
    public void test04(){

        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello", String::new));

    }

    @Test
    public void test05(){

    }
    @Test
    public void test06(){

    }
}
