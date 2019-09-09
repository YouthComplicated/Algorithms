package jdk.jdk8;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        System.out.println(names);

        /**
         * 表达式写法
         */
        // expression o2.compareTo(o1)

        // statement {return o2.compareTo(o1);}

//        Collections.sort(names, (o1, o2) -> {return o2.compareTo(o1);});

        /**
         * Reports Comparators defined as lambda expressions which could be expressed using methods like Comparator.comparing().
         * Some comparators like (person1, person2) -> person1.getName().compareTo(person2.getName())
         * could be simplified like this: Comparator.comparing(Person::getName).
         * Also suggests to replace chain comparisons with Comparator.thenComparing(),
         * e.g. int res = o1.first.compareTo(o2.first); if(res == 0) res = o1.second.compareTo(o2.second);
         * if(res == 0) res = o1.third - o2.third; return res; will be replaced with
         * objs.sort(Comparator.comparing((Obj o) -> o.first).thenComparing(o -> o.second).thenComparingInt(o -> o.third));
         */
        Collections.sort(names, Comparator.reverseOrder());

        System.out.println(names);




    }


}
