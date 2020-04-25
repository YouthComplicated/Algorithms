package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-25 11:06
 * @version: 0.0.1
 */
public class Code_788 {

    /**
     * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
     * Each digit must be rotated - we cannot choose to leave it alone.
     *
     * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to
     * each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate
     * to each other, and the rest of the numbers do not rotate to any other number and become invalid.
     *
     * Now given a positive number N, how many numbers X from 1 to N are good?
     *
     * Example:
     * Input: 10
     * Output: 4
     * Explanation:
     * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
     * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
     * Note:
     *
     * N  will be in range [1, 10000].
     *
     *
     * 特例：10、100、1000、10000
     *
     *   2、5、6、9  与 1、10组合
     *
     *  [0,1,2,5,6,9] => 排列组合描述：len = 3  从中取数最多为2个数重复 这种思路如何编程实现
     *
     *  换句话说，编程如何实现 A33 C32 排列组合公式
     *
     *
     *
     *
     */

    public int rotatedDigits(int N) {

        int len = String.valueOf(N).length();
        Set<String> set = new HashSet<>(Arrays.asList("3","4","7","8"));

        for (int i = 1; i <= N; i++) {
//            if(String.valueOf(i).contains()){
//
//            }
        }

        return 0;
    }


    /**
     *
     * 动态规划的思想的核心是什么
     *
     *
     *
     */
     public int rotatedDigits1(int N) {
         int count = 0;
         int[] dp = new int[N + 1];
         for (int i = 0; i <= N; i++) {
             if (i < 10) {
                 if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                 else if (i == 2 || i == 5 || i == 6 || i == 9) {
                     dp[i] = 2;
                     count++;
                 }
             } else {
                 int a = dp[i / 10], b = dp[i % 10];
                 if (a == 1 && b == 1) dp[i] = 1;
                 else if (a >= 1 && b >= 1) {
                     dp[i] = 2;
                     count++;
                 }
             }
         }
         return count;
     }


    public int rotatedDigits2(int N) {
        int[] valid = new int[10], good = new int[10];
        Arrays.fill(valid,1);
        valid[3] = valid[4] = valid[7] = 0;
        good[2] = good[5] = good[6] = good[9] = 1;
        int cntGoods = 0, cntSelves = 1, cntBoundedGoods = 0, cntBoundedSelves = 1;
        for(int k = N; k > 0; k /= 10){
            int dgt = k%10;
            cntBoundedGoods = good[dgt]*cntBoundedSelves + valid[dgt]*cntBoundedGoods;
            cntBoundedSelves = valid[dgt]*(good[dgt] == 0 ? 1 : 0)*cntBoundedSelves;
            for(int j = 0; j < dgt; ++j){
                cntBoundedGoods += good[j]*cntSelves + valid[j]*cntGoods;
                cntBoundedSelves += valid[j]*(good[j]^1)*cntSelves;
            }
            cntGoods = 7*cntGoods+4*cntSelves;
            cntSelves *= 3;
        }
        return cntBoundedGoods;
    }

    public static void main(String[] args) {

    }
}