package leetcode;

/**
 * @author: nj
 * @date: 2020-04-12 15:44
 * @version: 0.0.1
 */
public class Code_557 {


    /**
     * Given a string, you need to reverse the order of characters in each word within a sentence while still
     * preserving whitespace and initial word order.
     *
     * Example 1:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    public static String reverseWords(String s) {
        if(s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int start,end = 0;
        start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                end = i - 1;
                reverse(chars, start, end);
                start = i + 1;
            }
        }
        if(end < chars.length - 1){
            reverse(chars, start, chars.length - 1);
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end){
        char s;
        while (start < end){
            s = chars[start];
            chars[start] = chars[end];
            chars[end] = s;
            start ++;
            end --;
        }
    }


    public String reverseWords1(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords(" abc "));
        System.out.println(reverseWords(" abc ").length());

    }


}