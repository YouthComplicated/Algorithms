package leetcode;

/**
 * @author: nj
 * @date: 2020-03-22 11:15
 * @version: 0.0.1
 */
public class Code_268 {

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     *
     * Example 1:
     *
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     *
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */

    public static int missingNumber(int[] nums) {
        int [] arr = new int[nums.length+1];
        for(int i = 0; i < nums.length; i ++){
            arr[nums[i]] =  1;
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 ){
                res = i;
            }
        }
        return res;
    }

    public int missingNumber1(int[] nums) {
        int sum = 0;
        for(int a : nums) {
            sum += a;
        }
        int sumOriginal = 0;
        for(int i = 0; i < nums.length+1; i++) {
            sumOriginal += i;
        }
        return (sumOriginal - sum);

    }






    public static void main(String[] args) {
        int[] a1 = {3,0,1};
        System.out.println(missingNumber(a1));

        int[] a2 = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(a2));


    }


}