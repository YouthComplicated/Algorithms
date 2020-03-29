package leetcode;

/**
 * @author: nj
 * @date: 2020-03-29 10:59
 * @version: 0.0.1
 */
public class Code_453 {

    /**
     * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
     * where a move is incrementing n - 1 elements by 1.
     *
     * Example:
     *
     * Input:
     * [1,2,3]
     *
     * Output:
     * 3
     *
     * Explanation:
     * Only three moves are needed (remember each move increments two elements):
     *
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     *
     *
     * 纯数学模型进行穷解会涉及到大量的数学运算(乘除加减)，导致精度溢出
     *
     *
     *  sum + m * (n - 1) = x * n
     *
     *  x = minNum + m
     *
     *  sum - minNum * n = m
     *
     *
     */


    public static int minMoves(int[] nums) {
        int len;
        if(nums == null || (len = nums.length) <= 1){
            return 0;
        }
        int max = Integer.MIN_VALUE, res, sum = 0, factor;
        for (int i = 0; i < nums.length; i++) {
            if(max < nums[i]){
                max = nums[i];
            }
            sum += nums[i];
        }

        /**
         * 此处为基于max进行++操作
         */
        for (int i = max; ; i++) {
            /**
             * 数组越界问题
             */
            res = (len * i - sum) / (len - 1);
            factor = (len * i - sum) % (len - 1);
            if(factor == 0){
                return res;
            }
        }
    }


    public static int minMoves1(int[] nums) {
        int len;
        if(nums == null || (len = nums.length) <= 1){
            return 0;
        }
        int minValue = Integer.MAX_VALUE, res, sum = 0, factor;
        for (int i = 0; i < nums.length; i++) {
            if(minValue > nums[i]){
                minValue = nums[i];
            }
            sum += nums[i];
        }

        return sum - minValue * len;

    }


    public static void main(String[] args) {

        int [] nums = {1,2,3};
        System.out.println(minMoves(nums));


        int [] nums1 = {1};
        System.out.println(minMoves(nums1));


        int [] nums2 = {1,2};
        System.out.println(minMoves(nums2));


        //[1,1,2147483647]
        int [] nums3 = {1,1,2147483647};
        System.out.println(minMoves(nums3));



    }





}