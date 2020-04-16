package leetcode;

import java.util.HashMap;

/**
 * @author: nj
 * @date: 2020-04-15 16:38
 * @version: 0.0.1
 */
public class Code_594 {

    /**
     * We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.
     *
     * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible
     * subsequences.
     *
     * Example 1:
     *
     * Input: [1,3,2,2,5,2,3,7]
     * Output: 5
     * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
     *
     *
     * Note: The length of the input array will not exceed 20,000.
     *
     *
     *
     * Time complexity : O(n\log n). Sorting takes O(n\log n) time.
     *
     * Space complexity : O(\log n). \log nlogn space is required by sorting in average case.
     *
     *
     * 没有必要判断+- 两种情况，原因组合已经穷解
     */

    public static int findLHS(int[] nums) {

        if(nums == null){
            return 0;
        }
        int max = Integer.MIN_VALUE,tempA,tempB;
        int decreaseMax, increaseMax;
        for (int i = 0; i < nums.length - 1; i++) {
            decreaseMax = 0; increaseMax = 0;
            tempA = nums[i] + 1;
            tempB = nums[i] - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == nums[i]){
                    increaseMax ++;
                    decreaseMax ++;
                }
                if(tempA == nums[j]){
                    increaseMax ++;
                }
                if(tempB == nums[j]){
                    decreaseMax ++;
                }
            }
            max = Math.max(max,Math.max(increaseMax,decreaseMax));
        }

        return max+1;
    }


    public int findLHS11(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count ++;
                else if (nums[j] + 1 == nums[i]) {
                    count ++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }

    /**
     *
     * Time complexity : O(n). One loop is required to fill map and one for traversing the map.
     *
     * Space complexity : O(n). In worst case map size grows upto size n.
     *
     */
    public int findLHS111(int[] nums) {
        HashMap< Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    /**
     *
     * Time complexity : O(n). Only one loop is there.
     *
     * Space complexity : O(n). map size grows upto size n.
     *
     */
    public int findLHS112(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));

    }



}