package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-03-25 17:12
 * @version: 0.0.1
 */
public class Code_350 {


    /**
     *
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     *
     *
     * 与code349不同，原因是可以重复
     *
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     *
     * 1、What if the given array is already sorted? How would you optimize your algorithm?
     *    使用数组方式
     *
     * 2、What if nums1's size is small compared to nums2's size? Which algorithm is better?
     *    优先数据少的作为字典，循环数据大进行匹配
     *
     * 3、What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
     * load all elements into the memory at once?
     *    海量数据如何进行加载
     *
     *    海量日志文本等如何进行操作？
     *
     *
     */

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int [] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        Integer value, k = 0;
        for (int i = 0; i < nums2.length; i++) {
            value = map.get(nums2[i]);
            if(value != null && value != 0){
                result[k++] = nums2[i];
                map.put(nums2[i], --value);
            }
        }
        return Arrays.copyOf(result, k);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        System.out.println(Arrays.toString(intersect1(nums1,nums2)));

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4,5};
//        System.out.println(Arrays.toString(intersect1(nums3,nums4)));

        int[] nums5 = {-2147483648,1,2,3};
        int[] nums6 = {1,-2147483648,-2147483648};
//        System.out.println(Arrays.toString(intersect(nums5,nums6)));

    }



}