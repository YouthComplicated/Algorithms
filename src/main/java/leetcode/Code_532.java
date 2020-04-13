package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-11 15:15
 * @version: 0.0.1
 */
public class Code_532 {

    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
     * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their
     * absolute difference is k.
     *
     * Example 1:
     * Input: [3, 1, 4, 1, 5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * Example 2:
     * Input:[1, 2, 3, 4, 5], k = 1
     * Output: 4
     * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     * Example 3:
     * Input: [1, 3, 1, 5, 4], k = 0
     * Output: 1
     * Explanation: There is one 0-diff pair in the array, (1, 1).
     *
     * 暴力解法穷解
     *
     * 时间复杂度 O(n*n)
     * 特殊情况含有相同元素
     *
     */
    public static int findPairs1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int temp,t = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                temp = nums[i] + nums[j];
                if(Math.abs(nums[i] - nums[j]) == k && !set.contains(temp)){
                    t++;
                    set.add(temp);
                    if(t == 2){
                        break;
                    }
                }
            }
        }
        return set.size();
    }


    public static int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k){
                    set.add(nums[i] + nums[j]);
                }
            }
        }
        return set.size();
    }

    /**
     * 排序之后处理
     */

    public int findPairs44(int[] nums, int k) {
        if(k < 0 || nums.length < 2){
            return 0;
        }
        int result = 0, len = nums.length, i=0, j=1;
        Arrays.sort(nums);
        while(i < len && j < len){
            if(nums[j] - nums[i] == k){
                result++;
                i++;
                j++;
                while(j < len && nums[j-1] == nums[j]){
                    j++;
                }
            }else if(nums[j] - nums[i] > k){
                i++;
                if(i == j){
                    j++;
                }
            }else{
                j++;
            }
        }
        return result;
    }

    public int findPairs111(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5};
        System.out.println(findPairs(nums, 2));
        System.out.println(findPairs(nums, 1));
        System.out.println(findPairs(nums, 0));

        int [] nums1 = {3, 1, 4, 1, 5};
        System.out.println(findPairs(nums1, 0));
    }





}