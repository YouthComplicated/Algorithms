package leetcode;

/**
 * @author: nj
 * @date: 2020-04-21 20:53
 * @version: 0.0.1
 */
public class Code_747 {

    /**
     * In a given integer array nums, there is always exactly one largest element.
     *
     * Find whether the largest element in the array is at least twice as much as every other number in the array.
     *
     * If it is, return the index of the largest element, otherwise return -1.
     *
     * Example 1:
     *
     * Input: nums = [3, 6, 1, 0]
     * Output: 1
     * Explanation: 6 is the largest integer, and for every other number in the array x,
     * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
     *
     *
     * Example 2:
     *
     * Input: nums = [1, 2, 3, 4]
     * Output: -1
     * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
     *
     *
     * Note:
     *
     * nums will have a length in the range [1, 50].
     * Every nums[i] will be an integer in the range [0, 99].
     *
     *
     * 转化题目意思，找最大和第二大的数
     *
     * 注意如果为负数没有问题
     *
     *  -4、-2、1、4、8
     *
     */


    public static int dominantIndex(int[] nums) {

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max1Index = -1;

        for (int i = 0; i < nums.length; i++) {
            if(max1 < nums[i]){
               max2 = max1;
               max1 = nums[i];
               max1Index = i;
            }else if(max2 < nums[i]){
               max2 = nums[i];
            }
        }
        System.out.println("max1:" + max1 + "max2:" + max2);
        if(max1 > max2 * 2){
            return max1Index;
        }
        return -1;
    }





    public static void main(String[] args) {

        int[] arr = {0,0,0,1};
        System.out.println(dominantIndex(arr));

        int[] arr1 = {0,0,2,3};
        System.out.println(dominantIndex(arr1));
    }


}