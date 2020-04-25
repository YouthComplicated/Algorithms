package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-25 09:44
 * @version: 0.0.1
 */
public class Code_784 {


    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
     * Return a list of all possible strings we could create.
     *
     * Examples:
     * Input: S = "a1b2"
     * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * Input: S = "3z4"
     * Output: ["3z4", "3Z4"]
     *
     * Input: S = "12345"
     * Output: ["12345"]
     * Note:
     *
     * S will be a string with length between 1 and 12.
     * S will consist only of letters or digits.
     *
     *
     * 涉及到排列组合的问题
     *
     *    a、b、c
     *
     * 程序如何实现排列组合问题
     *
     *
     */

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        if(S == null){
            return result;
        }
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetter(chars[i])){

            }

        }

        return null;
    }


    public List<String> letterCasePermutation1(String S) {
        List<String> ans = new ArrayList<>(Arrays.asList(S));
        for (int i = 0; i < S.length(); ++i) { // Traverse string S char by char.
            for (int j = 0, sz = ans.size(); Character.isLetter(S.charAt(i)) && j < sz; ++j) { // S.charAt(i): letter, not digit.
                char[] ch = ans.get(j).toCharArray(); // transform to char[] the string @ j of ans.
                //char ^ (1 << 5) means to swap the 6th bit, which also means to +/-32 when the 6th bit is 0/1
                ch[i] ^= (1 << 5); // toggle case of charAt(i).
                ans.add(String.valueOf(ch)); // append to the end of ans.
                System.out.println();
            }
        }
        return ans;
    }


    /**
     *
     * BFS 广度优先遍历
     *
     */
    public List<String> letterCasePermutation2(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    /**
     *
     * DFS  深度优先遍历
     *
     */
    public List<String> letterCasePermutation3(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }




    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = new ArrayList<>(Arrays.asList(str));
        System.out.println(ans);

    }




}