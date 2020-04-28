package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-25 21:02
 * @version: 0.0.1
 */
public class Code_824 {

    /**
     * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
     *
     * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
     *
     * The rules of Goat Latin are as follows:
     *
     * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
     * For example, the word 'apple' becomes 'applema'.
     *
     * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
     * For example, the word "goat" becomes "oatgma".
     *
     * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
     * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
     * Return the final sentence representing the conversion from S to Goat Latin.
     *
     *
     *
     * Example 1:
     *
     * Input: "I speak Goat Latin"
     * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     * Example 2:
     *
     * Input: "The quick brown fox jumped over the lazy dog"
     * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     *
     *
     * Notes:
     *
     * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
     * 1 <= S.length <= 150.
     *
     *
     *
     *
     * 规则：
     *
     * 1、匹配 a e i o u  append ma
     *
     * 2、否则remove first append ma
     *
     * 3、add letter a
     *
     *
     *
     *
     */




    public static  String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder abuilder = new StringBuilder("a");
        for(String str : strs){
            if(set.contains(Character.toLowerCase(str.charAt(0)))){
                sb.append(str);
            }else{
                sb.append(str.substring(1   )).append(str.charAt(0));
            }
            sb.append("ma");
            sb.append(abuilder);
            abuilder.append("a");
            sb.append(" ");
        }
//        sb.substring(0, sb.length());

        return sb.toString().substring(0, sb.length() - 1);

    }


    public static void main(String[] args) {


        String str1 = "I speak Goat Latin";
        System.out.println(toGoatLatin(str1));

        String str2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(str2));



    }











}