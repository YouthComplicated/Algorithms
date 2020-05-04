package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-05-04 20:47
 * @version: 0.0.1
 */
public class Code_977 {


    /**
     *Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
     * also in sorted non-decreasing order.
     *
     * Example 1:
     *
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Example 2:
     *
     * Input: [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A is sorted in non-decreasing order.
     *
     *
     *
     */

    public static int[] sortedSquares(int[] A) {


        int[] ans = new int[A.length];
        int start = 0, end = A.length - 1, k = A.length - 1, a, b;
        while (start <= end){
            a = A[start] * A[start];
            b = A[end] * A[end];
            if(a > b){
                ans[k--] = a;
                start ++;
            }else{
                ans[k--] = b;
                end --;
            }
        }
        return ans;


    }

    public static void main(String[] args) {

        int[] A1 = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(A1)));

        int[] A2 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(A2)));



    }
}