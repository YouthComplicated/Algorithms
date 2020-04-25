package leetcode;

/**
 * @author: nj
 * @date: 2020-04-25 14:36
 * @version: 0.0.1
 */
public class Code_796 {



    /**
     * We are given two strings, A and B.
     *
     * A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
     * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if
     * A can become B after some number of shifts on A.
     *
     * Example 1:
     * Input: A = 'abcde', B = 'cdeab'
     * Output: true
     *
     * Example 2:
     * Input: A = 'abcde', B = 'abced'
     * Output: false
     * Note:
     *
     * A and B will have length at most 100.
     *
     *
     *
     *
     *
     */
    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length()){
            return false;
        }
        String temp = A + A;
        return temp.contains(B);

    }

    /**
     *  Time:O(N^2)
     *  space:1
     */
    public boolean rotateString1(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
        for (int s = 0; s < A.length(); ++s) {
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s+i) % A.length()) != B.charAt(i))
                    continue search;
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }



}