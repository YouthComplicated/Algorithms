package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-03-25 14:41
 * @version: 0.0.1
 */
public class Code_345 {


    /**
     *
     * Write a function that takes a string as input and reverse only the vowels of a string.(元音字母)
     *
     * Example 1:
     *
     * Input: "hello"
     * Output: "holle"
     * Example 2:
     *
     * Input: "leetcode"
     * Output: "leotcede"
     * Note:
     * The vowels does not include the letter "y".
     *
     *
     *
     * 只反转元音字母  a e i o u
     *
     *
     */
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        int start = 0;int end = s.length() - 1;
        char[] charArr = s.toCharArray();
        char temp;
        boolean left,right;
        while (start < end){
            left = set.contains(charArr[start]);
            right = set.contains(charArr[end]);
            if(!left){
                start ++;
            }
            if(!right){
                end --;
            }
            if(left && right){
                temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start ++;
                end --;
            }
        }
        return new String(charArr);
    }


    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }
}