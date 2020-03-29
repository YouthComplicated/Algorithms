package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-03-28 20:56
 * @version: 0.0.1
 */
public class Code_448 {


    /**
     *  Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     *
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     *
     * Example:
     *
     * Input:
     * [4,3,2,7,8,2,3,1]
     *
     * Output:
     * [5,6]
     */

    /**
     *
     * 使用数组下标充当map
     * 但是占用了O(n)空间
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        int [] indexArr = new int[len];
        for (int i = 0; i < len; i++) {
            indexArr[nums[i] - 1] ++;
        }
        for (int i = 0; i < len; i++) {
            if(indexArr[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }


    /**
     *
     * Space (O1)
     *
     * Time (n^2)
     *
     *
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        boolean isFind ;
        for (int i = 1; i <= len; i++) {
            isFind = false;
            for (int j = 0; j < len; j++) {
                if(nums[j] != 0){
                    if(i == nums[j]){
                        nums[j] = 0;
                        isFind = true;
                        break;
                    }
                }
            }
            if(!isFind){
                result.add(i);
            }
        }
        return result;
    }

    /**
     *
     * Space()
     *
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int n = nums.length;
        List<Integer> results = new ArrayList<>();
        for(int i=0; i < n; i++) {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
            System.out.println(Arrays.toString(nums));
        }
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                results.add(i+1);
            }
        }
        return results;
    }

    public static void main(String[] args) {

        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
        System.out.println(findDisappearedNumbers1(arr));

        int[] arr1 = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(arr1));



    }






}