package leetcode;

/**
 * @author: nj
 * @date: 2020-04-28 18:27
 * @version: 0.0.1
 */
public class Code_852 {


    /**
     * Let's call an array A a mountain if the following properties hold:
     *
     * A.length >= 3
     * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ...
     *  > A[A.length - 1].
     *
     * Example 1:
     *
     * Input: [0,1,0]
     * Output: 1
     * Example 2:
     *
     * Input: [0,2,1,0]
     * Output: 1
     * Note:
     *
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A is a mountain, as defined above.
     *
     *
     *
     *
     */

    public int peakIndexInMountainArray(int[] A) {

        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if(A[i] < A[i - 1]){
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 高级的炫技，但是不使用，会有空指针(假设给的数组不符合题意)
     */
    public int peakIndexInMountainArray1(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }


    public static void main(String[] args) {

    }




}