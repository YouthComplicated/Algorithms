package jdk.jdk8.stream2;

import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.minBy;

public class StreamTest {

    Student student1 = new Student("zhangsan", 80);
    Student student2 = new Student("lisi", 90);
    Student student3 = new Student("wangwu", 100);
    Student student4 = new Student("zhaoliu", 90);
    Student student5 = new Student("zhaoliu", 90);

    List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);



    @Test
    public void test01(){

        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("------------");

        //越具体的方法越好，优先使用 students.stream().count()
        System.out.println("count: " + students.stream().collect(counting()));
        System.out.println("count: " + students.stream().count());



        System.out.println("------------");
        Map<Integer, Map<String, List<Student>>> map = students.stream().
                collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);
        System.out.println("------------");

        Map<Boolean, List<Student>> map2 = students.stream().
                collect(partitioningBy(student -> student.getScore() > 80));
        System.out.println(map2);
        System.out.println("------------");

        Map<Boolean, Map<Boolean, List<Student>>> map3 = students.stream().
                collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 90)));
        System.out.println(map3);
        System.out.println("------------");

        Map<Boolean, Long> map4 = students.stream().
                collect(partitioningBy(student -> student.getScore() > 80, counting()));
        System.out.println(map4);
        System.out.println("------------");

        Map<String, Student> map5 = students.stream().
                collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)),
                        Optional::get)));
        System.out.println(map5);

    }
    @Test
    public void test02(){

        students.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);

        System.out.println(students.stream().collect(averagingInt(Student::getScore)));
        System.out.println(students.stream().collect(summingInt(Student::getScore)));

        /**
         *
         * 汇总信息
         *
         * A state object for collecting statistics such as count, min, max, sum, and average.
         *
         * IntSummaryStatistics  DoubleSummaryStatistics  LongSummaryStatistics
         */
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);
    }
    @Test
    public void test03(){

        System.out.println(students.stream().map(Student::getName).collect(joining()));
        System.out.println(students.stream().map(Student::getName).collect(joining(", ")));
        System.out.println(students.stream().map(Student::getName).collect(joining(", ", "<begin> ", " <end>")));


    }
    @Test
    public void test04(){

        //students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);

        /**
         * java.lang.ClassCastException:
         * jdk.jdk8.stream2.Student cannot be cast to java.lang.Comparable
         */
        students.stream().sorted().count();

    }
    @Test
    public void test05(){

    }
    @Test
    public void test06(){

    }
    @Test
    public void test07(){

    }
    @Test
    public void test08(){

    }
}
