package leetcode;

import base.Arrays.Array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPartitionI_561 {

    /**
     *      Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     *      say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     *
     *      Example 1:
     *      Input: [1,4,3,2]
     *
     *      Output: 4
     *      Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     *      Note:
     *      n is a positive integer, which is in the range of [1, 10000].
     *      All the integers in the array will be in the range of [-10000, 10000].
     *
     *
     *
     *      eg:排序从小到大  取奇数相加
     */

    public static int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i += 2){
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {4,2,1,5,62,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arrayPairSum(arr));
    }


}
