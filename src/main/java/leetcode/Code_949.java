package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-05-03 18:40
 * @version: 0.0.1
 */
public class Code_949 {


    /**
     * Given an array of 4 digits, return the largest 24 hour time that can be made.
     *
     * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger
     * if more time has elapsed since midnight.
     *
     * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,4]
     * Output: "23:41"
     * Example 2:
     *
     * Input: [5,5,5,5]
     * Output: ""
     *
     *
     * Note:
     *
     * A.length == 4
     * 0 <= A[i] <= 9
     *
     *
     * h = 0-2   max = 2,1,0   2[0,1,2,3]  1[0-9]
     *   = 0-3   max = 3,2,1,0
     *   = 0-5   max = 5,4,3,2,1,0
     *   = 0-9   max =
     *
     *
     *
     */

    public static String largestTimeFromDigits(int[] A) {


        if(A == null || A.length != 4){
            return "";
        }

        int[] arr = new int[10];
        for (int i : A) {
            arr[i] ++;
        }

        String ans = "";
        boolean isHave = false;
        for (int i = 2; i >=0; i--) {
            if(arr[i] != 0){
                ans += i;
                arr[i] --;
                isHave = true;
                break;
            }
        }

        if(!isHave){
            return "";
        }

        isHave = false;
        for (int i = 3; i >=0; i--) {
            if(arr[i] != 0){
                ans += i;
                arr[i] --;
                isHave = true;
                break;
            }
        }

        if(!isHave){
            return "";
        }

        ans += ":";

        isHave = false;
        for (int i = 5; i >=0; i--) {
            if(arr[i] != 0){
                ans += i;
                arr[i] --;
                isHave = true;
                break;
            }
        }

        if(!isHave){
            return "";
        }

        for (int i = 9; i >=0; i--) {
            if(arr[i] != 0){
                ans += i;
                break;
            }
        }


        return ans;

    }


    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4};
        System.out.println(largestTimeFromDigits(arr1));

        int[] arr2 = {5,5,5,5};
//        System.out.println(largestTimeFromDigits(arr2));

    }


}