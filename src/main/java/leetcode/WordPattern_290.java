package leetcode;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordPattern_290 {

    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     *
     *
     * Example 1:
     *
     * Input: pattern = "abba", str = "dog cat cat dog"
     * Output: true
     * Example 2:
     *
     * Input:pattern = "abba", str = "dog cat cat fish"
     * Output: false
     * Example 3:
     *
     * Input: pattern = "aaaa", str = "dog cat cat dog"
     * Output: false
     * Example 4:
     *
     * Input: pattern = "abba", str = "dog dog dog dog"
     * Output: false
     * Notes:
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
     */

    public static void main(String[] args) {

        System.out.println(WordPattern_290.wordPattern("abba","dog cat cat dog"));
        System.out.println(WordPattern_290.wordPattern("abba","dog cat cat fish"));
        System.out.println(WordPattern_290.wordPattern("aaaa","dog cat cat dog"));
        System.out.println(WordPattern_290.wordPattern("abcba","dog t t t dog"));


    }


    public boolean wordPattern1(String pattern, String str) {
        String[] format = new String[26];
        boolean[] used = new boolean[26];
        StringTokenizer st = new StringTokenizer(str);
        int cnt = 0;
        while(cnt < pattern.length()) {
            if(!st.hasMoreTokens()) {
                return false;
            }
            String part = st.nextToken();
            int pat = pattern.charAt(cnt) - 'a';
            if(!used[pat]) {
                for(int i = 0; i < 26; i++) {
                    if(used[i] && format[i].equals(part)) {
                        return false;
                    }
                }
                format[pat] = part;
                used[pat] = true;
            } else {
                if(!format[pat].equals(part)) {
                    return false;
                }
            }
            cnt++;
        }
        if(st.hasMoreTokens()) {
            return false;
        }
        return true;
    }

    /**
     * my test
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        int patternLen = pattern.length(), strLen = strings.length;
        if(patternLen != strLen){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        String value;
        for(int i = 0; i < patternLen; i++){
            value = map.get(pattern.charAt(i));
            if(value == null){
                //判断strings[i]是否为map中value
                if(map.containsValue(strings[i])){
                    return false;
                }else{
                    map.put(pattern.charAt(i),strings[i]);
                }
            }else{
                if(!value.equals(strings[i])){
                    return false;
                }
            }
        }
        return true;
    }





}
