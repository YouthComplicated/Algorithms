package jdk;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-10-12 12:01
 * @version: 0.0.1
 */
public class Test1 {

    private final  Integer i ;

    private final int value[] = {1,2,4};

    public Test1(Integer i) {
        this.i = i;
//        this.value = {1,2,4};
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1(1);
        test1.value[0] = 3;
        System.out.println(Arrays.toString(test1.value));
        int [] aa = {1,4,5};

//        test1.value  = aa;

        StringBuilder sb = new StringBuilder(1);
        System.out.println(sb.toString());
        System.out.println("aa:" + sb.length());
        sb.append("1");
        System.out.println(sb.hashCode());
        sb.append("b");
        System.out.println(sb.hashCode());



        String c1 = "abcd";
    }
}
