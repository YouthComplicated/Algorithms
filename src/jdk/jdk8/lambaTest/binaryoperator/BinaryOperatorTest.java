package jdk.jdk8.lambaTest.binaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {


    public static void main(String[] args) {

        BinaryOperatorTest test = new BinaryOperatorTest();
        System.out.println(test.compute(1,2, (a,b) -> a + b));
        System.out.println(test.compute(3,1,(a,b) -> a - b));


        System.out.println(test.compareStr("aaa", "1234", (a, b) -> a.length() - b.length()));

        System.out.println(test.compareStr("aaa", "1234", Comparator.comparingInt(String::length)));

        System.out.println(test.compareStr("aaa", "1234", (a, b) -> b.length() - a.length()));

    }


    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    public String compareStr(String a, String b, Comparator<String> comparator){
        return  BinaryOperator.maxBy(comparator).apply(a,b);
    }
}
