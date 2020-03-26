package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-25 14:27
 * @version: 0.0.1
 */
public class Code_344 {
    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place
     * with O(1) extra memory.
     *
     * You may assume all the characters consist of printable ascii characters.
     *
     *
     *
     * Example 1:
     *
     * Input: ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */

    public static void reverseString(char[] s) {
        if(s == null){
            return ;
        }
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }

    public void reverseString1(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        char [] a1 = {'h','e','l','l','o'};
        char [] a2 = {'h','e','l','l','o','!'};
        char [] a3 = {'h','e'};
        char [] a4 = {'h'};
        char [] a5 = {};

        reverseString(a1);
        reverseString(a2);
        reverseString(a3);
        reverseString(a4);
        reverseString(a5);
        reverseString(null);

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
        System.out.println(Arrays.toString(a5));




    }




}