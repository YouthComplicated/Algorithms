package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 10:04
 * @version: 0.0.1
 */
public class Code_387 {

    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */
    public static int firstUniqChar(String s) {
        int [] res = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res[chars[i] - 'a'] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(res[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * 从两端开始遍历， 26字符
     *
     *
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        int index = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i >= 0 && i == s.lastIndexOf(c)) {
                index = i < index ? i : index;
            }
        }

        return index == s.length() ? -1 : index;
    }

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));


    }



}