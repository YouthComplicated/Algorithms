package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: nj
 * @date: 2020-05-10 08:06
 * @version: 0.0.1
 */
public class Code_1005 {

    /**
     *
     *
     *
     * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i],
     * and we repeat this process K times in total.  (We may choose the same index i multiple times.)
     *
     * Return the largest possible sum of the array after modifying it in this way.
     *
     *
     *
     * Example 1:
     *
     * Input: A = [4,2,3], K = 1
     * Output: 5
     * Explanation: Choose indices (1,) and A becomes [4,-2,3].
     * Example 2:
     *
     * Input: A = [3,-1,0,2], K = 3
     * Output: 6
     * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
     * Example 3:
     *
     * Input: A = [2,-3,-1,5,-4], K = 2
     * Output: 13
     * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
     *
     *
     * Note:
     *
     * 1 <= A.length <= 10000
     * 1 <= K <= 10000
     * -100 <= A[i] <= 100
     *
     *
     */

    public static int largestSumAfterKNegations(int[] A, int K) {

        Arrays.sort(A);
        int sum = 0, j = 0, prev = 0;
        for (int a : A) {
//            System.out.println(a);
            if(j < K) {
                if(a < 0){
                    sum = sum - a;
                    j++;
                }else if(a == 0){
                    j = K;
                }else{
                    //a > 0
                    if ((K - j) % 2 != 0){
                        if(j == 0){
                            sum -= a;
                        }else if(Math.abs(prev) < a){
                            sum = sum + prev * 2 + a;
                        }else{
                            sum -= a;
                        }
                    }else{
                        sum += a;
                    }
                    j = K;
                }
                prev = a;
            }else{
                sum += a;
            }
        }
        return sum;
    }

    public int largestSumAfterKNegations1(int[] A, int K) {
        Arrays.sort(A);
        for (int i=0; i< A.length && K > 0 && A[i] < 0; i++,K--) {
            A[i] = -A[i];
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            ans+=a;
            min = Math.min(min,a);
        }
        return ans - (K%2)*2*min;
    }


    public static int largestSumAfterKNegations2(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr1 = {4,2,3};
//        System.out.println(largestSumAfterKNegations(arr1, 1));

        int[] arr2 = {3,-1,0,2};
        System.out.println(largestSumAfterKNegations(arr2, 4));

        int[] arr3 = {2,-3,-1,5,-4};
//        System.out.println(largestSumAfterKNegations(arr3, 2));

        int[] arr4 = {-2,9,9,8,4};
//        System.out.println(largestSumAfterKNegations(arr4, 5));


//        int[] arr5 = {1,2,3,4,5};
//        System.out.println(largestSumAfterKNegations(arr5, 5));


    }



}