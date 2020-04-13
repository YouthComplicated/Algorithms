package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: nj
 * @date: 2020-04-10 20:55
 * @version: 0.0.1
 */
public class Code_506 {

    /**
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
     * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     *
     * Example 1:
     * Input: [5, 4, 3, 2, 1]
     * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and
     * "Bronze Medal".
     * For the left two athletes, you just need to output their relative ranks according to their scores.
     * Note:
     * N is a positive integer and won't exceed 10,000.
     * All the scores of athletes are guaranteed to be unique.
     *
     *
     * [5, 4, 3, 2, 1]
     *
     *
     * [3,4,6,1,2]
     *
     * 1,2,3,4,6
     *
     *
     * 绕不开排序过程，但map使用可以用其它方法替代
     *
     */
    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int len = nums.length;
        Map<Integer, String> map = new HashMap<>();
        map.put(nums[len - 1], "Gold Medal");
        if(len == 2){
            map.put(nums[len - 2], "Silver Medal");
        }else if(len >= 3){
            map.put(nums[len - 2], "Silver Medal");
            map.put(nums[len - 3], "Bronze Medal");
        }
        int k = 4;
        for (int i = len - 4; i >= 0 ; i--) {
            map.put(nums[i], String.valueOf(k++));
        }
        for (int i = 0; i < temp.length; i++) {
            result[i] = map.get(temp[i]);
        }

        return result;
    }


    /**
     *
     * 使用二维数组，不使用map
     *
     * 二维数组的排序，可以研究研究？？
     *
     */
    public String[] findRelativeRanks1(int[] nums) {
        int[][] pair = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }

    /**
     *  基于以上方法排序
     */
    public String[] findRelativeRanks2(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        /**
         * 传入的构造器巧妙的使用另外一个数组特性进行排序
         */
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }
        return result;
    }

    /**
     *
     *
     *  没有排序还是基于数组的下标进行细节操作
     *
     *  前提是找到最大的max,开辟max空间(缺点会浪费无用的内存)
     *
     *
     */
    public String[] findRelativeRanks3(int[] nums) {
        int len = nums.length;
        String[] res = new String[len];
        int max = -1;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] s_map = new int[max+1];

        for (int i = 0; i < len; i++) {
            s_map[nums[i]] = i + 1;
        }

        int rank = 1;
        for (int i = max; i >= 0; i--) {
            if (s_map[i] > 0) {
                if (rank == 1) {
                    res[s_map[i] - 1] = "Gold Medal";
                } else if (rank == 2) {
                    res[s_map[i] - 1] = "Silver Medal";
                } else if (rank == 3) {
                    res[s_map[i] - 1] = "Bronze Medal";
                } else {
                    res[s_map[i] - 1] = Integer.toString(rank);
                }
                rank++;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int [] arr1 = {5, 4, 3, 2, 9};
        System.out.println(Arrays.toString(findRelativeRanks(arr1)));

        int [] arr2 = {2, 9};
        System.out.println(Arrays.toString(findRelativeRanks(arr2)));

        int [] arr3 = {1};
        System.out.println(Arrays.toString(findRelativeRanks(arr3)));


        int [] arr4 = {};
        System.out.println(Arrays.toString(findRelativeRanks(arr4)));

    }


}