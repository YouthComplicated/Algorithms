package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-04 19:34
 * @version: 0.0.1
 */
public class Code_482 {

    /**
     * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string
     * is separated into N+1 groups by N dashes.
     *
     * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for
     * the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must
     * be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
     *
     * Given a non-empty string S and a number K, format the string according to the rules described above.
     *
     * Example 1:
     * Input: S = "5F3Z-2e-9-w", K = 4
     *
     * Output: "5F3Z-2E9W"
     *
     * Explanation: The string S has been split into two parts, each part has 4 characters.
     * Note that the two extra dashes are not needed and can be removed.
     * Example 2:
     * Input: S = "2-5g-3-J", K = 2
     *
     * Output: "2-5G-3J"
     *
     * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it
     * could be shorter as mentioned above.
     *
     * Note:
     * The length of string S will not exceed 12,000, and K is a positive integer.
     * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
     * String S is non-empty.
     */

    public static String licenseKeyFormatting(String S, int K) {

        char[] chars = S.toCharArray();
        int len = chars.length, k = 0, j = 0;
        char[] temp = new char[len + len / K];
        char tp;
        for (int i = len - 1; i >= 0 ; i--) {
            tp = chars[i];
            if(k == K ){
                System.out.println("i"+k);
                temp[j++] = '-';
                k = 0;
            }
            if(Character.isLetterOrDigit(tp)){
                k++;
                temp[j++] = Character.toUpperCase(tp);
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(temp)+"j:"+ j);
        int l = j - 1;
        if(l >= 0 && temp[l] != '-'){
            sb.append(temp[l]);
        }
        for (l = l - 1; l >= 0 ; l--) {
            sb.append(temp[l]);
        }
        return sb.toString();
    }

    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != '-'){
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            }
        }

        return sb.reverse().toString().toUpperCase();
    }


    public String licenseKeyFormatting11(String S, int k) {
        char[] arr = S.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] == '-') {
                fast++;
            } else {
                if (arr[fast] >= 'a' && arr[fast] <= 'z') {
                    arr[slow++] = (char)(arr[fast++] - 'a' + 'A');
                } else {
                    arr[slow++] = arr[fast++];
                }
            }
        }
        int len = slow + (slow - 1)/k;
        char[] res = new char[len];
        fast = len - 1;
        slow--;
        while (fast >= 0) {
            for (int i = 0; i < k && fast >= 0; i++) {
                res[fast--] = arr[slow--];
            }
            if (fast >= 0) {
                res[fast--] = '-';
            }
        }
        return new String(res);
    }


    public static void main(String[] args) {


//        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
//        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
//        System.out.println(licenseKeyFormatting("aaaa", 2));



//        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(licenseKeyFormatting("---", 3));


    }


}