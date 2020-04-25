package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-25 09:35
 * @version: 0.0.1
 */
public class Code_771 {


    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
     * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     *
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
     * so "a" is considered a different type of stone from "A".
     *
     * Example 1:
     *
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * Example 2:
     *
     * Input: J = "z", S = "ZZ"
     * Output: 0
     * Note:
     *
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     *
     *
     * 字符串字典比较
     *
     *
     * 使用数组代替HashSet
     */

    public int numJewelsInStones(String J, String S) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))){
                result++;
            }
        }

        return result;


    }


    public static void main(String[] args) {

    }



}