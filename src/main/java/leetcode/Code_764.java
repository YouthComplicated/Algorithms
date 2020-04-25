package leetcode;

/**
 * @author: nj
 * @date: 2020-04-19 12:41
 * @version: 0.0.1
 */
public class Code_764 {


    /**
     * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
     *
     * Example 1:
     * Input: [1,3,5,4,7]
     * Output: 3
     * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
     * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
     * Example 2:
     * Input: [2,2,2,2,2]
     * Output: 1
     * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
     * Note: Length of the array will not exceed 10,000.
     *
     *
     *
     *
     */
    public static int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0, k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                k++;
            }else{
                max = Math.max(max, k);
                k = 1;
            }
        }
        max = Math.max(max, k);
        return max;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }


    public static void main(String[] args) {

        int[] arr1 = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(arr1));

        int[] arr2 = {2,2,2};
        System.out.println(findLengthOfLCIS(arr2));

        int[] arr3 = {1};
        System.out.println(findLengthOfLCIS(arr3));

        int[] arr4 = {1,2,3,0,5,6,7,8,9};
        System.out.println(findLengthOfLCIS(arr4));
    }










}