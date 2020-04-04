package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 10:27
 * @version: 0.0.1
 */
public class Code_389 {

    /**
     * Given two strings s and t which consist of only lowercase letters.
     *
     * String t is generated by random shuffling string s and then add one more letter at a random position.
     *
     * Find the letter that was added in t.
     *
     * Example:
     *
     * Input:
     * s = "abcd"
     * t = "abcde"
     *
     * Output:
     * e
     *
     * Explanation:
     * 'e' is the letter that was added.
     *
     *
     * 类似map统计每个字符出现的次数
     *
     */
    public char findTheDifference(String s, String t) {
        char [] charsA = s.toCharArray();
        char [] charsB = t.toCharArray();
        int [] a = new int[26];
        int [] b = new int[26];
        for (int i = 0; i < charsA.length; i++) {
            a[charsA[i] - 'a'] ++;
        }
        for (int i = 0; i < charsB.length; i++) {
            b[charsB[i] - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if(a[i] != b[i]){
                return (char)(i + 'a');
            }
        }
        return ' ';

    }

    /**
     * 加法求sum
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference11(String s, String t) {
        char res = 0;
        for (int i = 0; i < t.length(); i++) {
            res += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            res -= s.charAt(i);
        }
        return res;
    }

    /**
     * 此方法最快 使用未运算符   ^   相同为
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference1(String s, String t) {
        int random = 0;
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for(int i = 0; i < source.length; i++ ) {
            random = random^source[i]^target[i];
        }
        random = random ^ target[target.length-1];

        return ((char) random);
    }

    public static void main(String[] args) {
        System.out.println('a' ^ 'a');
        System.out.println('a' ^ 'b');
        System.out.println('a' ^ 'b' ^ 'a');
    }
}