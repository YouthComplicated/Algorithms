package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 17:26
 * @version: 0.0.1
 */
public class Code_409 {
    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
     * that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     */

    public static int longestPalindrome(String s) {
        int[] chars = new int[58];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'A'] ++;
        }
        int res = 0, temp;
        boolean hasSingle = false;
        for (int i = 0; i < chars.length; i++) {
            temp = chars[i];
            if(temp % 2 == 0){
                res += temp;
            }else{
                hasSingle = true;
                res = res + (temp/2) * 2;
            }
        }
        return hasSingle ? res+1 : res;
    }


    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));

    }



}