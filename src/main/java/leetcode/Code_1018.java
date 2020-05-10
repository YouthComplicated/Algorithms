package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-05-10 10:35
 * @version: 0.0.1
 */
public class Code_1018 {


    /**
     * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number
     * (from most-significant-bit to least-significant-bit.)
     *
     * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
     *
     * Example 1:
     *
     * Input: [0,1,1]
     * Output: [true,false,false]
     * Explanation:
     * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5,
     * so answer[0] is true.
     * Example 2:
     *
     * Input: [1,1,1]
     * Output: [false,false,false]
     * Example 3:
     *
     * Input: [0,1,1,1,1,1]
     * Output: [true,false,false,false,true,false]
     * Example 4:
     *
     * Input: [1,1,1,0,1]
     * Output: [false,false,false,false,false]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 30000
     * A[i] is 0 or 1
     *
     *
     *
     * 溢出的问题
     */

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for(int a : A){
            sum = (sum << 1) + a;
//            System.out.println(sum);
            if(sum % 5 == 0){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    /**
     * So we need to use some Math Knowledge(I learnt it from Cryptography Course if my memory services my right):
     * Consider the formula below which is the key to this problem:
     *
     * (a * b + c) % d = ((a % d) * (b % d) + c % d) % d
     * Simply say is that we mod each part in a * b + c, then mod the result.
     *
     * So in this problem, num = (num << 1) + cur which can be written as num = num * 2 + (0 or 1).
     * From above trick, we get num % 5 = (num % 5) * (2 % 5) + (0 or 1) % 5. Since 2, 0, 1 all smaller than 5,
     * so they mod 5 do not cause any difference, we simplify the formula to => num % 5 = 2 * (num % 5) + (0 or 1).
     */
    public List<Boolean> prefixesDivBy51(int[] A) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
            ans.add(k == 0);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = {0,1,1};
        System.out.println(prefixesDivBy5(arr1));

        int[] arr2 = {1,1,1};
        System.out.println(prefixesDivBy5(arr2));

        int[] arr3 = {0,1,1,1,1,1};
        System.out.println(prefixesDivBy5(arr3));

        int[] arr4 = {1,1,1,0,1};
        System.out.println(prefixesDivBy5(arr4));

        int[] arr5 = {1,1,0,0,0,1,0,0,1};
        System.out.println(prefixesDivBy5(arr5));

    }


}