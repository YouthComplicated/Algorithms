package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-30 19:15
 * @version: 0.0.1
 */
public class Code_922 {

    /**
     * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
     *
     * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
     *
     * You may return any answer array that satisfies this condition.
     *
     *
     *
     * Example 1:
     *
     * Input: [4,2,5,7]
     * Output: [4,5,2,7]
     * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
     *
     *
     * Note:
     *
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     *
     *
     */

    public static int[] sortArrayByParityII(int[] A) {

        int evenIndex = 0, oddIndex = 1, len = A.length;
        int [] ans = new int[len];
        for (int a : A) {
            if(a % 2 == 0){
                ans[evenIndex] = a;
                evenIndex += 2;
            }else{
                ans[oddIndex] = a;
                oddIndex += 2;
            }
        }
        return ans;

    }



    public static void main(String[] args) {
        int[] arr1 = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr1)));

    }





}