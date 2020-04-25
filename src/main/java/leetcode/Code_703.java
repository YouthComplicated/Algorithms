package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: nj
 * @date: 2020-04-19 21:04
 * @version: 0.0.1
 */
public class Code_703 {


    /**
     *
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     *
     * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains
     * initial elements from the stream. For each call to the method KthLargest.add, return the element representing
     * the kth largest element in the stream.
     *
     * Example:
     *
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     * Note:
     * You may assume that nums' length ≥ k-1 and k ≥ 1.
     *
     *
     *
     * 如果使用数组，考察数组插入元素，移动位置的问题
     *
     * 使用原生数组的话，初始化容量问题(k与nums不匹配问题)，初始化和扩容等相关
     *
     *
     *
     *
     *
     */



    int[] num;
    public Code_703(int k, int[] nums) {
        if(nums.length == 0){
            return;
        }
        num = new int[k];
        Arrays.sort(nums);
        int len = nums.length, j = 0;
        for (int i = len - k; i < len; i++) {
            num[j++] = nums[i];
        }
        System.out.println(Arrays.toString(num));
    }

    /**
     * [4,6,9,2];
     *
     */
    public int add(int val) {
        if(num == null){
            num = new int[1];
            num[0] = val;
        }
        int len = num.length;
        int j = 0;
        if(val > num[len - 1]){
            while (j < len - 1){
                num[j] = num[j+1];
                j++;
            }
            num[len - 1] = val;
        }else{
            for (int i = 0; i < len - 1; i++) {
                if(val >= num[i] && val < num[i+1]){
                    while (j < i){
                        num[j] = num[j+1];
                        j++;
                    }
                    num[i] = val;
                }
            }
        }
        System.out.println(Arrays.toString(num));
        return num[0];

    }





    public static void main(String[] args) {
        /**
         * 8,5,4
         */
//        int[] nums = {4,5,8,2};
//        Code_703 code = new Code_703(3, nums);
//        System.out.println(code.add(3));  //4
//        System.out.println(code.add(5));  //5
//        System.out.println(code.add(10)); //5
//        System.out.println(code.add(9));  //8
//        System.out.println(code.add(4));  //8


        int[] nums = {};
        Code_703 code = new Code_703(1, nums);
        System.out.println(code.add(-3));  //4
        System.out.println(code.add(-2));  //5
        System.out.println(code.add(-4)); //5
        System.out.println(code.add(0));  //8
        System.out.println(code.add(4));  //8



    }
}