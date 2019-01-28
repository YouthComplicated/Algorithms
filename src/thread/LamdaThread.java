package thread;

import java.util.Arrays;
import java.util.List;

public class LamdaThread {

    public static void main(String[] args) {
        List<Integer> vals = Arrays.asList(1,2,3,4,5);
        //vals.add(22);
        System.out.println("计算结果为："+ new LamdaThread().calNum(vals));
    }

    private int calNum(List<Integer> vals){

//        vals.stream().forEach(System.out::println);
//        vals.parallelStream().forEachOrdered(System.out::println);

        vals.parallelStream().forEach(System.out::println);
        return vals.parallelStream().mapToInt(i->i*2).sum();

    }
}