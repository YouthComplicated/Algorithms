package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-18 18:32
 * @version: 0.0.1
 */
public class Code_645 {


    /**
     *
     * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers
     * in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
     *
     * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number
     * occurs twice and then find the number that is missing. Return them in the form of an array.
     *
     * Example 1:
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * Note:
     * The given array size will in the range [2, 10000].
     * The given array's numbers won't have any order.
     *
     *
     *
     */

    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - 1] ++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 2){
                result[0] = i + 1;
            }
            if(arr[i] == 0){
                result[1] = i + 1;
            }
        }
        return result;
    }

    public int[] findErrorNums1(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i],i+1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {

        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
        int[] nums1 = {2,2};
        System.out.println(Arrays.toString(findErrorNums(nums1)));

    }




}