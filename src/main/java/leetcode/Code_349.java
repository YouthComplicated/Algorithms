package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-03-25 15:35
 * @version: 0.0.1
 */
public class Code_349 {

    /**
     *
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Note:
     *
     * Each element in the result must be unique.
     * The result can be in any order.
     *
     * 抽象出集合操作 交并补
     *
     * 数组的快速去重
     *
     * 数组的快速统计出现的字母数量
     *
     * 集合的交集 字符串的匹配规则
     *
     * 快速的匹配电话号码
     *
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
           set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

//        set1.retainAll(set2);
//        System.out.println(set1);
        int[] res = new int[set2.size()];
        int k = 0;
        for (Integer i : set2) {
            res[k++] = i;
        }
        return res;

    }

    /**
     * 找到nums1 数组最大和最小值 此方法有问题？？数组越界
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找到nums1 数组最大和最小值
        for(int n : nums1){
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }
        for(int n : nums2){
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }

        //max min 是两个数组组合之后最大最小(目的是为了节省分配的内存空间)
        boolean[] memo = new boolean[max-min+1];
        for(int n : nums1){
            memo[n-min]=true;
        }
        int[] res=new int[nums1.length<nums2.length?nums1.length:nums2.length];
        int k=0;
        for(int n:nums2){
            if(memo[n-min]){
                res[k++]=n;
            }
            memo[n-min]=false;
        }
        return Arrays.copyOf(res,k);
    }


    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        System.out.println(Arrays.toString(intersection(nums1,nums2)));

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
//        System.out.println(Arrays.toString(intersection(nums3,nums4)));


        int[] nums5 = {-2147483648,1,2,3};
        int[] nums6 = {1,-2147483648,-2147483648};
        System.out.println(Arrays.toString(intersection1(nums5,nums6)));

    }


}