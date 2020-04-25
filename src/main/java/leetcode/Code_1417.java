package leetcode;

/**
 * @author: nj
 * @date: 2020-04-20 20:13
 * @version: 0.0.1
 */
public class Code_1417 {


    /**
     *
     * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
     *
     * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed
     * by another digit. That is, no two adjacent characters have the same type.
     *
     * Return the reformatted string or return an empty string if it is impossible to reformat the string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "a0b1c2"
     * Output: "0a1b2c"
     * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid
     * permutations.
     * Example 2:
     *
     * Input: s = "leetcode"
     * Output: ""
     * Explanation: "leetcode" has only characters so we cannot separate them by digits.
     * Example 3:
     *
     * Input: s = "1229857369"
     * Output: ""
     * Explanation: "1229857369" has only digits so we cannot separate them by characters.
     * Example 4:
     *
     * Input: s = "covid2019"
     * Output: "c2o0v1i9d"
     * Example 5:
     *
     * Input: s = "ab123"
     * Output: "1a2b3"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 500
     * s consists of only lowercase English letters and/or digits.
     *
     *
     * 栽树问题（）
     *
     */

    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int expectLen = len / 2 + 1;
        char[] arr = new char[chars.length];
        char[] letterArr = new char[len];
        char[] digitArr = new char[len];
        int j = 0, k = 0;
        for (int i = 0; i < chars.length; i++) {
            if(j > expectLen || k > expectLen){
                return "";
            }
            if(Character.isLetter(chars[i])){
                letterArr[j++] = chars[i];
            }else{
                digitArr[k++] = chars[i];
            }
        }
        if(Math.abs(j-k) > 1){
            return "";
        }
        boolean isLetterFirst = false;
        if(j >= k){
            isLetterFirst = true;
        }
        int t1 = 0, t2 = 0;
        if(isLetterFirst){
            for (int i = 0; i < len; i++) {
                if(i % 2 == 0){
                    arr[i] = letterArr[t1++];
                }else{
                    arr[i] = digitArr[t2++];
                }
            }
        }else{
            for (int i = 0; i < len; i++) {
                if(i % 2 == 0){
                    arr[i] = digitArr[t2++];
                }else{
                    arr[i] = letterArr[t1++];
                }
            }
        }
        return  new String(arr);

    }



    public static void main(String[] args) {

        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
        System.out.println(reformat("covid2019"));




    }


}