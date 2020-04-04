package leetcode;

/**
 * @author: nj
 * @date: 2020-03-31 09:46
 * @version: 0.0.1
 */
public class Code_459 {

    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of
     * the substring together. You may assume the given string consists of lowercase English letters only and its length
     * will not exceed 10000.
     *
     *
     *
     * Example 1:
     *
     * Input: "abab"
     * Output: True
     * Explanation: It's the substring "ab" twice.
     * Example 2:
     *
     * Input: "aba"
     * Output: False
     * Example 3:
     *
     * Input: "abcabcabcabc"
     * Output: True
     * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     *
     *
     *  理解错了，哈哈哈哈
     *
     *  有病了哈
     *
     *
     *  kmp算法
     *
     *
     */
    public static boolean repeatedSubstringPattern(String s) {
        int len, k, j, t;
        if(s == null || (len = s.length()) <= 1){
            return false;
        }
        char c;
        boolean flag;
        for(int i = 0; i < len - 1; i++){
            k = i + 1;
            c = s.charAt(i);
            while (k < len){
                if(c == s.charAt(k)){
                    j = k + 1; t = i + 1;
                    flag = true;
                    while( t < k && j < len){
                        if(s.charAt(t) != s.charAt(j)){
                            flag = false;
                            break;
                        }
                        j++;
                        t++;
                    }
                    if(!flag){
                        break;
                    }
                    if(t < k && j == len){
                        break;
                    }
                    if(t == k){
                        return true;
                    }
                }else{
                    k++;
                }
            }
        }
        return false;
    }



    public static boolean repeatedSubstringPattern1(String s){
        return (s+s).substring(1,2*s.length()-1).contains(s);
    }

    public boolean repeatedSubstringPattern2(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length()-1];
        int n = str.length();
        return (len > 0 && n%(n-len) == 0);
    }

    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abac"));
        System.out.println(repeatedSubstringPattern("aac"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("a"));
        System.out.println(repeatedSubstringPattern("ababba"));


    }



}