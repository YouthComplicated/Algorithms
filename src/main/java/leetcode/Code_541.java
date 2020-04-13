package leetcode;

/**
 * @author: nj
 * @date: 2020-04-11 19:35
 * @version: 0.0.1
 */
public class Code_541 {



    /**
     *
     *
     *
     * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
     * from the start of the string. If there are less than k characters left, reverse all of them. If there are less than
     * 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     * Restrictions:
     * The string consists of lower English letters only.
     * Length of the given string and k will in the range [1, 10000]
     *
     *  123abcgf
     *  321abc
     *
     */

    public static String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int start = 0, end = k;

        for (; start < len ; start += 2 * k) {
            end = start + k - 1;
            if(end > len - 1 ){
                end = len - 1;
            }
            System.out.println("start:" + start + "end:" + end);
            reserve(chars, start, end);
        }
        return new String(chars);
    }

    public static void reserve(char[] chars, int start, int end){
        char temp;
        while (start < end){
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start ++;
            end --;
        }
    }


    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("123abcgf", 3));


    }


}