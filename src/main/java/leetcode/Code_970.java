package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-05-04 19:38
 * @version: 0.0.1
 */
public class Code_970 {

    /**
     * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some
     * integers i >= 0 and j >= 0.
     *
     * Return a list of all powerful integers that have value less than or equal to bound.
     *
     * You may return the answer in any order.  In your answer, each value should occur at most once.
     *
     * Example 1:
     *
     * Input: x = 2, y = 3, bound = 10
     * Output: [2,3,4,5,7,9,10]
     * Explanation:
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     * Example 2:
     *
     * Input: x = 3, y = 5, bound = 15
     * Output: [2,4,6,8,10,14]
     *
     * Note:
     *
     * 1 <= x <= 100
     * 1 <= y <= 100
     * 0 <= bound <= 10^6
     *
     *
     *
     */

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {

        int min =  x > y ? y : x;
        int loop = 0, temp = bound;
        if(min == 1){
            loop = bound;
        }else{
            while (temp > 0){
                temp = temp / min;
                loop ++;
            }
        }
        Set<Integer> set = new HashSet<>();
        double ans;
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < loop; j++) {
                ans = Math.pow(x,i) + Math.pow(y,j);
                if( ans <= bound){
                    set.add((int)ans);
                }else{
                    break;
                }
            }
        }
        return new ArrayList<>(set);

    }


    public List<Integer> powerfulIntegers1(int x, int y, int bound) {
        ArrayList<Integer> as = new ArrayList<>();

        int maxA = 1;
        if(x>1) {
            for(int i = 0 ; i<100; i++) {
                if(Math.pow(x, i) >= bound) {
                    maxA = i;
                    break;
                }
            }
        }
        int maxB = 1;
        if(y>1) {
            for(int i = 0; i<100; i++) {
                if(Math.pow(y, i)>= bound) {
                    maxB = i;
                    break;
                }
            }
        }

        for(int i = 0; i < maxA; i++) {
            for(int j = 0; j < maxB; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if(sum <= bound && !as.contains(sum)) {
                    as.add(sum);
                }
            }
        }
        return as;
    }


    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }


    public static void main(String[] args) {


//        System.out.println(powerfulIntegers(3,5 ,10));
//        System.out.println(powerfulIntegers(3,5 ,15));
//        System.out.println(powerfulIntegers(2,2 ,15));
        System.out.println(powerfulIntegers(2,1 ,10));



    }

}