package leetcode;

import java.util.Arrays;

public class DegreeArray_697 {


    /**
     * Given a non-empty array of non-negative integers nums, the degree of this array
     * is defined as the maximum frequency of any one of its elements.
     *
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
     * that has the same degree as nums.
     *
     * Example 1:
     * Input: [1, 2, 2, 3, 1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * Example 2:
     * Input: [1,2,2,3,1,4,2]
     * Output: 6
     * Note:
     *
     * nums.length will be between 1 and 50,000.
     * nums[i] will be an integer between 0 and 49,999.
     */



    public static int findShortestSubArray(int[] nums) {
        if(nums.length == 1){
            return  0;
        }
        int max = -1;
        int min = 50000;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        int [][] arr = new int[max - min+2][3];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]-min + 1][0]++;
            if(arr[nums[i]-min + 1][0] == 1){
                arr[nums[i]-min + 1][1] = i;
            }else{
                arr[nums[i]-min + 1][2] = i;
            }
        }
        int maxIndex = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE,temp;


        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] >= maxIndex){
                maxIndex = arr[i][0];
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] == maxIndex){
                if( arr[i][2] == 0){
                    result = 0;
                }else if((temp = arr[i][2] -arr[i][1]) <= result){
                    result = temp;
                }
            }
        }
        return  result+1;
    }


    public static int findShortestSubArray1(int[] nums) {
        int[] indexs = new int[50000];
        int[] degree = new int[50000];
        for (int i = 0; i < 50000; i++) {
            indexs[i] = -1;
        }
        int max = 1, len = 1;
        for (int i = 0; i < nums.length; i++) {
            if (indexs[nums[i]] == -1) {
                indexs[nums[i]] = i;
            }
            degree[nums[i]]++;
            if (degree[nums[i]] > max) {
                max = degree[nums[i]];
                len = i - indexs[nums[i]] + 1;
            } else if (degree[nums[i]] == max && len > i - indexs[nums[i]] + 1) {
                len = i - indexs[nums[i]] + 1;
            }
        }
        return len;
    }


    public static void main(String[] args) {

        int [] arr1 = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(arr1));
        int [] arr2 = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(arr2));


        int [] arr3 = {1,2};
        System.out.println(findShortestSubArray(arr3));
    }


}
