package leetcode;

/**
 * @author: nj
 * @date: 2020-04-30 10:14
 * @version: 0.0.1
 */
public class Code_908 {

    /**
     * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
     *
     * After this process, we have some array B.
     *
     * Return the smallest possible difference between the maximum value of B and the minimum value of B.
     *
     *
     *
     * Example 1:
     *
     * Input: A = [1], K = 0
     * Output: 0
     * Explanation: B = [1]
     * Example 2:
     *
     * Input: A = [0,10], K = 2
     * Output: 6
     * Explanation: B = [2,8]
     * Example 3:
     *
     * Input: A = [1,3,6], K = 3
     * Output: 0
     * Explanation: B = [3,3,3] or B = [4,4,4]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     * 0 <= K <= 10000
     *
     *
     * k = max k;  min k
     *
     * A sort [1,2,3] ==>  min   max
     *
     *
     *
     *
     */

    public int smallestRangeI(int[] A, int K) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if(A[i] > max){
                max = A[i];
            }
            if(A[i] < min){
                min = A[i];
            }
        }
        int ans = max - min - 2 * K;

        return ans < 0 ? 0 : ans;

    }

    /**
     * 寻找最大和最小使用 提供的API
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI1(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }



}