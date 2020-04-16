package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-15 15:16
 * @version: 0.0.1
 */
public class Code_581 {

    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order, too.
     *
     * You need to find the shortest such subarray and output its length.
     *
     * Example 1:
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * Note:
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.
     *
     *
     *
     */


    public static int findUnsortedSubarray(int[] nums) {

        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(nums[i] != arr[i]){
                start = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(nums[i] != arr[i]){
                end = i;
                break;
            }
        }
        return start > end ? 0 : end - start + 1;

    }

    /**
     *
     * 找出左边第二小的数 找出右边第二大的数
     *
     */
    public static int findUnsortedSubarray1(int[] A) {
        int n = A.length;
        int start = -1, end = -2;
        int min = A[n - 1], max = A[0];
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (A[i] < max) end = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            if (A[i] > min) start = i;
        }
        return end - start + 1;
    }

    public int findUnsortedSubarray2(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }


    public static void main(String[] args) {
        int [] arr = {2, 6, 4, 8, 10, 9, 15};

//        System.out.println(findUnsortedSubarray(arr));


        System.out.println(findUnsortedSubarray1(arr));





    }


}