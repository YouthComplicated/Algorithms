package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-04-25 21:34
 * @version: 0.0.1
 */
public class Code_830 {


    /**
     * In a string S of lowercase letters, these letters form consecutive groups of the same character.
     *
     * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
     *
     * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
     *
     * The final answer should be in lexicographic order.
     *
     *
     *
     * Example 1:
     *
     * Input: "abbxxxxzzy"
     * Output: [[3,6]]
     * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
     * Example 2:
     *
     * Input: "abc"
     * Output: []
     * Explanation: We have "a","b" and "c" but no large group.
     * Example 3:
     *
     * Input: "abcdddeeeeaabbbcd"
     * Output: [[3,5],[6,9],[12,14]]
     *
     *
     *
     * 如何有优雅的判断连续相等的字符 不是按照常规思路找到首个字符之后再匹配
     *
     *
     */
    public static List<List<Integer>> largeGroupPositions(String S) {

        char[] arr = S.toCharArray();
        List<List<Integer>> result = new ArrayList<>();
        int start;
        for (int i = 1; i < arr.length; i++) {
            start = i - 1;
            if(arr[i] == arr[i-1]){
                while (i + 1 < arr.length){
                    if(arr[i] != arr[i + 1]){
                        break;
                    }
                    i++;
                }
                if(i - start >= 2){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {


        System.out.println(largeGroupPositions("abbxxxxzzy"));

//        System.out.println(largeGroupPositions("abc"));


        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));




    }



}