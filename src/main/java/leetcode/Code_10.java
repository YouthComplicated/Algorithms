package leetcode;

/**
 * @author: nj
 * @date: 2020-02-02 20:55
 * @version: 0.0.1
 */
public class Code_10 {

    /**
     *
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     *
     *Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * Example 3:
     *
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
     * Example 5:
     *
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     *
     *
     */


    /**
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     *
     * @return
     */
    public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int k = 0;
        for(int i = 0; i < sArr.length; i++ ){
            if(sArr[i] == pArr[k]){
                k++;
                continue;
            }else{
                if('.' == pArr[i]){

                }else if('*' == pArr[i]){

                }else{


                }
            }


        }
        return true;
    }


    public static void main(String[] args) {





    }











}