package leetcode;

/**
 * @author: nj
 * @date: 2020-04-19 15:07
 * @version: 0.0.1
 */
public class Code_680 {

    /**
     *
     *
     * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
     *
     * Example 1:
     * Input: "aba"
     * Output: True
     * Example 2:
     * Input: "abca"
     * Output: True
     * Explanation: You could delete the character 'c'.
     * Note:
     * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
     *
     * 注意：  a 为回文数
     *      ab 符合
     *
     *  以下是整个过程思路查找，但是不正确，过多的条件判断，
     *  没有将流程一些部分进行进行封装和拆分，简化解题的思路
     *
     */
    public static boolean validPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.length() < 3){
            return true;
        }
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1, k = 0;
        boolean hasSame = false;
        boolean isFind = false;
        while (start < end){
            if(arr[start] == arr[end]){
                hasSame = true;
                start ++;
                end --;
            }else{
                if(isFind){
                    return false;
                }
                if(start + 1 < end && arr[start + 1] == arr[end]){
                    isFind = true;
                    start += 2;
                    end --;
                }else if(end - 1 > start && arr[end - 1] == arr[start]){
                    isFind = true;
                    end = end - 2;
                    start ++;
                }else{
                    if(end - start != 1){
                        return false;
                    }
                    start ++;
                    end --;
                }
            }
        }
        return hasSame;
    }

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome1(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                /**
                 * 找到要剔除的点，右端或者左端，然后在进行回文数判断
                 */
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return true;
        int i = 0;
        int j = len - 1;
        boolean isOutOfPlace = false;
        return isValid(s,isOutOfPlace, 0, len - 1 );

    }

    private boolean isValid(String s, boolean isOutOfPlace, int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(isOutOfPlace) return false; //as we have already found one out of place
                else{
                    isOutOfPlace = true;
                    return isValid(s, isOutOfPlace, i + 1, j) || isValid(s, isOutOfPlace, i, j - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("aabctcba"));
        System.out.println(validPalindrome("a"));
        System.out.println(validPalindrome("12t340yyt4321"));
        System.out.println(validPalindrome("tebbem"));
        System.out.println(validPalindrome("yd"));

        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));

    }

}