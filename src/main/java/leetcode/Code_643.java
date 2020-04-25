package leetcode;

/**
 * @author: nj
 * @date: 2020-04-18 17:21
 * @version: 0.0.1
 */
public class Code_643 {

    /**
     *
     * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum
     * average value. And you need to output the maximum average value.
     *
     * Example 1:
     *
     * Input: [1,12,-5,-6,50,3], k = 4
     * Output: 12.75
     * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     *
     *
     * Note:
     *
     * 1 <= k <= n <= 30,000.
     * Elements of the given array will be in the range [-10,000, 10,000].
     */

    public static double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE, sum;
        for (int i = 0; i < nums.length - k + 1; i++) {
            sum = 0.0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
                System.out.println(sum);
            }
            System.out.println();
            max = Math.max(sum, max);
        }
        System.out.println();
        return max / k;

    }

    public double findMaxAverage1(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }


    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
        int[] nums1 = {5};
        System.out.println(findMaxAverage(nums1, 1));
        int[] nums2 = {0,1,1,3,3};
        System.out.println(findMaxAverage(nums2, 4));
    }






}