package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-21 20:23
 * @version: 0.0.1
 */
public class Code_744 {

    /**
     *
     * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
     * find the smallest element in the list that is larger than the given target.
     *
     * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
     *
     * Examples:
     * Input:
     * letters = ["c", "f", "j"]
     * target = "a"
     * Output: "c"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "c"
     * Output: "f"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "d"
     * Output: "f"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "g"
     * Output: "j"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "j"
     * Output: "c"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "k"
     * Output: "c"
     * Note:
     * letters has a length in range [2, 10000].
     * letters consists of lowercase letters, and contains at least 2 unique letters.
     * target is a lowercase letter.
     *
     *
     *
     *
     *
     * 特别粗暴的解法:
     *
     * 1、排序 2、成环查找遍历  必需排序
     *
     *
     *
     * 2、使用数组
     *
     *
     * 给出的是排序之后的数组，没有看清题目的意思
     *
     *
     */


    public static char nextGreatestLetter1(char[] letters, char target) {
        Arrays.sort(letters);
        for (int i = 0; i < letters.length; i++) {
            if(target < letters[i]){
                return letters[i];
            }
        }
        return letters[0];
    }



    public static char nextGreatestLetter(char[] letters, char target) {
        char[] result = new char[26];
        for (int i = 0; i < letters.length; i++) {
            result[letters[i] - 'a'] = 1;
        }
        char firstChar;

        int targetIndex = target - 'a';
        for (int j = targetIndex + 1; j < 26 ; j++) {
            if(result[j] != 0){
                return (char)(j + 'a');
            }
        }

        for (int i = 0; i < targetIndex; i++) {
            if(result[i] != 0){
                return (char)(i + 'a');
            }
        }

        return ' ';

    }

    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }






    public static void main(String[] args) {

        char[] arr1 = {'c','f','j'};
        System.out.println(nextGreatestLetter(arr1, 'a'));

        char[] arr2 = {'c','f','j'};
        System.out.println(nextGreatestLetter(arr2, 'c'));

        char[] arr3 = {'c','f','j'};
        System.out.println(nextGreatestLetter(arr3, 'd'));

        char[] arr4 = {'c','f','j'};
        System.out.println(nextGreatestLetter(arr4, 'g'));
        System.out.println(nextGreatestLetter(arr4, 'j'));
        System.out.println(nextGreatestLetter(arr4, 'k'));


    }







}