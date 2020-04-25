package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-22 19:13
 * @version: 0.0.1
 */
public class Code_748 {

    /**
     * 
     * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
     * Such a word is said to complete the given string licensePlate
     *
     * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
     *
     * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
     *
     * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP",
     * the word "pair" does not complete the licensePlate, but the word "supper" does.
     *
     * Example 1:
     * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
     * Output: "steps"
     * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
     * Note that the answer is not "step", because the letter "s" must occur in the word twice.
     * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
     * Example 2:
     * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
     * Output: "pest"
     * Explanation: There are 3 smallest length words that contains the letters "s".
     * We return the one that occurred first.
     * Note:
     * licensePlate will be a string with length in range [1, 7].
     * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
     * words will have a length in the range [10, 1000].
     * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
     *
     *
     *
     * words only letters
     *
     * licensePlate  digits + spaces + letters
     *
     * 字典表预处理:去除多余字符串、
     *
     * 连续字母匹配
     * 
     *
     */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Set<String> dictSet = new HashSet<>();
        char[] chars = licensePlate.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if(Character.isLetter(chars[i])){
                String str =  Character.toLowerCase(chars[i] )+ "";
                if(Character.toLowerCase(chars[i]) ==
                        Character.toLowerCase(chars[i + 1])){
                    while (i + 1 < chars.length){
                        if(Character.toLowerCase(chars[i]) ==
                                Character.toLowerCase(chars[i+1])){
                            str += Character.toLowerCase(chars[i+1]);
                            i++;
                        }else{
                            break;
                        }
                    }
                }
                dictSet.add(str);
            }
        }

        System.out.println(dictSet.toString());

        String tempStr,resultStr = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            tempStr = words[i];
            char[] arr = tempStr.toCharArray();
            for (int j = 0; j < arr.length - 1; j++) {
                String str =  arr[j] + "";
                if((arr[j]) == (arr[j + 1])){
                    while (j + 1 < chars.length){
                        if(arr[j] == arr[j+1]){
                            str += arr[j+1];
                            j++;
                        }else{
                            break;
                        }
                    }
                }
                if(dictSet.contains(str)){
                    if(tempStr.length() < min){
                        resultStr = tempStr;
                        min = tempStr.length();
                    }
                }
            }

        }
        return resultStr;
    }

    public String shortestCompletingWord1(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int [] charMap = new int[26];
        // Construct the character map
        for(int i = 0 ; i < target.length(); i++){
            if(Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            if(matches(word, charMap) && word.length() < minLength) {
                minLength = word.length();
                result  = words[i];
            }
        }
        return result;
    }
    private boolean matches(String word, int[] charMap){
        int [] targetMap = new int[26];
        for(int i = 0; i < word.length(); i++){
            if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(charMap[i]!=0 && targetMap[i]<charMap[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        String[] words = {"step", "steps", "stripe", "stepple"};
//        System.out.println(shortestCompletingWord("1s3 456", words));
//
//
//        String[] words1 = {"looks", "pest", "stew", "show"};
//        System.out.println(shortestCompletingWord("1s3 456", words1));


        String[] words2 = {"sloosks", "spest", "stew", "hsowwwt"};
        System.out.println(shortestCompletingWord("1wWw3 456", words2));

    }


}