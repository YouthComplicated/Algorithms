package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-10 14:29
 * @version: 0.0.1
 */
public class Code_167 {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     *
     * Note:
     *
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Example:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     */


    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int start = 0, end = length-1;
        int mindle = (start + end)/2;

        int temp;
        while(end - start != 1 ){
            if(end - start % 2 != 0){
                temp = numbers[mindle] + numbers[mindle+1];
            }else{
                temp = numbers[mindle] * 2;
            }
            if(temp < target * 2){
                start = mindle;
            }else{
                end = mindle;
            }
        }
        int [] result = new int[2];
        result[0] = start;
        result[1] = end;
        return result;


    }


    public static int[] twoSum1(int[] numbers, int target){
        int [] nums = new int[2];
        if (numbers.length == 0) {
            return nums;
        }
        int i =0;
        int j =numbers.length-1;
        while (i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                nums[0] = i+1;
                nums[1] = j+1;
                return nums;
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }



    public static void main(String[] args) {
        int[] aa = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(aa,9)));
        int[] a1 = {1,2,3};
        System.out.println(Arrays.toString(twoSum(a1,3)));
        int[] a2 = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(a2,9)));
        int[] a3 = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(a3,9)));


    }


}