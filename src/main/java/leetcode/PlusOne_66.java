package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne_66 {
    /**
     *
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element
     * in the array contain a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     *
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int[] temp = new int[digits.length + 1];
        int j = 0;
        if(digits[digits.length - 1] + 1 == 10){
            temp[j] = 0;
            flag = true;
        }else{
            temp[j] = digits[digits.length - 1] + 1;
        }
        for( int i = digits.length - 2; i >= 0; i-- ){
            if(flag && digits[i] + 1 == 10){
                flag = true;
                temp[++j] = 0;
            }else if(flag){
                temp[++j] = digits[i] + 1;
                flag = false;
            }else{
                temp[++j] = digits[i];
                flag = false;
            }
        }
        int [] result;
        //判断是否多出一位
        if(temp[j] == 0){
            temp[j+1] = 1;
            result = new int[j+2];
        }else{
            result = new int[j+1];
        }
        //数组反转
        int s = 0;
        for(int k = result.length -1; k >= 0; k--){
            result[s++] = temp[k];
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        int num = 0;
//        for(int i = 0; i < arr.length; i++){
//            num = num*10 + arr[i];
//        }
//        System.out.println(num);

        int[] arr = {8};
//        int[] arr = {1,2,3};
//        int [] arr = {9,9,9};
//        int[] arr = {8,9,9,9};
        PlusOne_66 one_66 = new PlusOne_66();
        System.out.println(Arrays.toString(one_66.plusOne(arr)));


    }
}
