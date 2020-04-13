package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: nj
 * @date: 2020-04-10 10:15
 * @version: 0.0.1
 */
public class Code_496 {

    /**
     *
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
     * the next greater numbers for nums1's elements in the corresponding places of nums2.
     *
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does
     * not exist, output -1 for this number.
     *
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     *   For number 4 in the first array, you cannot find the next greater number for it in the second array,so output -1.
     *   For number 1 in the first array, the next greater number for it in the second array is 3.
     *   For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     *     For number 2 in the first array, the next greater number for it in the second array is 3.
     *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     * Note:
     * All elements in nums1 and nums2 are unique.
     * The length of both nums1 and nums2 would not exceed 1000.
     *
     *
     * 正常的思维逻辑去处理
     *
     * 时间复杂度:o(n*n)
     *
     * 空间复杂度:o(1)
     *
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a,b,j;
        int [] result = new int[nums1.length];
        boolean isFind;
        for (int i = 0; i < nums1.length; i++) {
            a = nums1[i];
            j = 0;
            while (j < nums2.length){
                b = nums2[j];
                if(a == b){
                    isFind = false;
                    while (j + 1 < nums2.length){
                        if( nums2[j+1] > a){
                            isFind = true;
                            break;
                        }
                        j++;
                    }
                    result[i] = isFind ? nums2[j+1] : -1;
                    break;
                }
                j++;
            }

        }

        return result;

    }

    /**
     *
     *
     * 数组构造map(有界)，遍历查找
     *
     *
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] map = new int[10000];
        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = map[nums1[i]]; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
                if (nums1[i] >= nums2[j] && j == nums2.length - 1) {
                    nums1[i] = -1;
                    break;
                }
            }
        }
        return nums1;
    }

    /**
     *
     *
     * 时间复杂度:o(n)
     *
     * 空间复杂度:o(1)
     *
     *
     */
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }




    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));

    }
}