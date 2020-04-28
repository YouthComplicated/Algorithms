package leetcode;

import base.Arrays.Array;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-25 20:10
 * @version: 0.0.1
 */
public class Code_821 {

    /**
     *
     * Given a string S and a character C, return an array of integers representing the shortest distance from the character
     * C in the string.
     *
     * Example 1:
     *
     * Input: S = "loveleetcode", C = 'e'
     * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     *
     *
     * Note:
     *
     * S string length is in [1, 10000].
     * C is a single character, and guaranteed to be in string S.
     * All letters in S and C are lowercase.
     *
     *
     */

    public static int[] shortestToChar(String S, char C) {

        char[] arr = S.toCharArray();
        int[] result = new int[S.length()];
        int left, right;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != C){
                left = i - 1;
                right = i + 1;
                while (true){
                    if(left >= 0){
                        if(arr[left] == C){
                            result[i] = i - left;
                            break;
                        }
                        left --;
                    }
                    if(right < arr.length){
                        if(arr[right] == C){
                            result[i] = right - i;
                            break;
                        }
                        right ++;
                    }
                }
            }
        }
        return result;

    }

    public static int[] shortestToChar1(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        System.out.println(Arrays.toString(ans));

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            System.out.println(prev-i);
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    /**
     *
     * DP
     *
     */
    public int[] shortestToChar2(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i)
            res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i)
            res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }


    public static void main(String[] args) {
        String str1 = "loveleetcode";
        char c1 = 'e';
        System.out.println(Arrays.toString(shortestToChar1(str1, c1)));

        String str2 = "baaa";
        char c2 = 'b';
        System.out.println(Arrays.toString(shortestToChar(str2, c2)));
    }


}