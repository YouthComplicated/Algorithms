package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-14 10:22
 * @version: 0.0.1
 */
public class Code_189 {

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: [-1,-100,3,99] and k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * Note:
     *
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     */


    public static void rotate(int[] nums, int k) {
        int temp, size = nums.length;
        for(int i = 0; i < k; i++){
            temp = nums[size - 1];
            for(int j = size - 2; j >= 0; j--){
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));

        int[] b = {-1,-100,3,99};
        rotate(b, 2);
        System.out.println(Arrays.toString(b));
    }















}