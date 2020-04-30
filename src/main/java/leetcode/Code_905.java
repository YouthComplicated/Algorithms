package leetcode;

/**
 * @author: nj
 * @date: 2020-04-30 10:32
 * @version: 0.0.1
 */
public class Code_905 {

    /**
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
     * followed by all the odd elements of A.
     *
     * You may return any answer array that satisfies this condition.
     *
     *
     * Example 1:
     *
     * Input: [3,1,2,4]
     * Output: [2,4,3,1]
     * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     *
     *
     * Note:
     *
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     *
     *
     * 奇数偶数排列  even elements +  odd elements
     *
     * 1、先分类 然后在组装(使用list或者数组存储奇数和偶数
     *
     * 2、
     *
     *
     *
     */

    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        int start = 0, end = len - 1;
        for (int a : A) {
            if(a % 2 == 0){
                ans[start++] = a;
            }else{
                ans[end--] = a;
            }
        }
        return ans;
    }

    public int[] sortArrayByParity1(int[] A) {
        int len = A.length;
        int evenIndex = 0, oddIndex = 0, start = 0, end;
        for (int i = 1; i < len; i++) {

        }

        int[] result = new int[len];

        return result;

    }


    public static void main(String[] args) {


    }


}