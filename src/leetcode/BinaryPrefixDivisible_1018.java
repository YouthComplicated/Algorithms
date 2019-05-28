package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisible_1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            //运算符优先级 巨坑
           sum =  (A[i] + (sum<<1));
            System.out.println(sum);
            result.add(sum % 5 == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisible_1018  instance = new BinaryPrefixDivisible_1018();
//        int [] aa = {0,1,1};
//        System.out.println(instance.prefixesDivBy5(aa));
//        int [] bb = {1,1,1};
//        System.out.println(instance.prefixesDivBy5(bb));
//        int [] cc = {0,1,1,1,1,1};
//        System.out.println(instance.prefixesDivBy5(cc));
//        int [] dd = {1,1,1,0,1};
//        System.out.println(instance.prefixesDivBy5(dd));

        int [] ff = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        System.out.println(instance.prefixesDivBy5(ff));

        System.out.println(2<<1);

        System.out.println((0<<1)+1);
    }
}
