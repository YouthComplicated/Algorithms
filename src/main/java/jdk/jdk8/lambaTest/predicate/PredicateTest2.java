package jdk.jdk8.lambaTest.predicate;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * 条件过滤器
 */
public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();


//        predicateTest2.conditionFilter(list, item -> item % 2 == 0);
//        predicateTest2.conditionFilter(list, item -> item % 2 != 0);
//        predicateTest2.conditionFilter(list, item -> item > 5);
//        predicateTest2.conditionFilter(list, item -> item < 3);
//        predicateTest2.conditionFilter(list, item -> true);
//        predicateTest2.conditionFilter(list, item -> false);


        predicateTest2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);

        System.out.println(predicateTest2.isEqual(new Date()).test(new Date()));


    }


    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer integer : list) {
            if(predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    /**
     * 复合式的条件拼接
     * @param list
     * @param predicate
     * @param predicate2
     */
    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate,
                                 Predicate<Integer> predicate2) {
        for(Integer integer : list) {
            // !(item > 5 && item % 2 == 0)
            if(predicate.and(predicate2).negate().test(integer)) {
                System.out.println(integer);
            }
        }

    }

    public Predicate<Date> isEqual(Object object) {
        return Predicate.isEqual(object);
    }



//    public void findAllEvens(List<Integer> list) {
//        for(Integer integer : list) {
//            if(integer % 2 == 0) {
//                System.out.println(integer);
//            }
//        }
//    }





}
