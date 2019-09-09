package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {

    /**
     *
     * Given an array of integers, find if the array contains any duplicates.
     *
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     *
     * Example 1:
     *
     * Input: [1,2,3,1]
     * Output: true
     * Example 2:
     *
     * Input: [1,2,3,4]
     * Output: false
     * Example 3:
     *
     * Input: [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     */

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.get(i) != null){
                return true;
            }else{
                map.put(i,1);
            }
        }
        return false;


    }

    public static boolean containsDuplicate1(int[] nums) {
        if(nums==null|nums.length==0) return false;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int range = max - min + 1;

        if (range < nums.length) {
            return true;
        }

        int[] frequency = new int[range];

        for (int num : nums) {
            frequency[num - min]++;
            if (frequency[num - min] > 1) {
                return true;
            }
        }

        return false;
    }




    //time:O(n^2) space:O(1) 暴力解
    /*
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if(nums==null||nums.length==0) return false;
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]==nums[j]) return true;
                }
            }
            return false;
        }
    }
    */


    public static void main(String[] args) {

    }
}
