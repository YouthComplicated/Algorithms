package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-22 17:17
 * @version: 0.0.1
 */
public class Code_283 {


    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the
     * relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */
    public static void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(k != i){
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        int [] a1 = {0,1,0,3,12};
        moveZeroes(a1);
        int [] a2 = {1,9,0,3,12};
        moveZeroes(a2);
        int [] a3 = {0,0,0,3,12};
        moveZeroes(a3);







    }




}