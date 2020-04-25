package leetcode;

/**
 * @author: nj
 * @date: 2020-04-20 14:43
 * @version: 0.0.1
 */
public class Code_704 {

    /**
     * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function
     *
     * to search target in nums. If target exists, then return its index, otherwise return -1.
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     *
     * Example 2:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     *
     *
     * Note:
     *
     * You may assume that all elements in nums are unique.
     * n will be in the range [1, 10000].
     * The value of each element in nums will be in the range [-9999, 9999].
     *
     *
     *
     *
     *
     */

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1,index;
        while (end - start > 1){
            index = start + (end - start) / 2;
            if(nums[index] < target){
                start = index + 1;
            }else if(nums[index] > target){
                end = index;
            }else{
                return index;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }


    public static int search1(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start+ (end - start)/2;
            if(nums[mid] < target)
                start = mid + 1;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                return mid;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search1(nums, 9));


        int[] nums1 = {-1,0,3,5,9,12};
        System.out.println(search1(nums1, 2));

        int[] nums2 = {-1};
        System.out.println(search1(nums2, -1));



    }




}