package leetcode;

/**
 * @author: nj
 * @date: 2020-04-19 20:42
 * @version: 0.0.1
 */
public class Code_709 {

    /**
     * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
     *
     *
     *
     * Example 1:
     *
     * Input: "Hello"
     * Output: "hello"
     * Example 2:
     *
     * Input: "here"
     * Output: "here"
     * Example 3:
     *
     * Input: "LOVELY"
     * Output: "lovely"
     *
     *
     *
     *
     */
    public static String toLowerCase(String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] = (char)(chars[i] + ('a' - 'A'));
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {


        System.out.println(toLowerCase("AAvvfrR"));
    }


}