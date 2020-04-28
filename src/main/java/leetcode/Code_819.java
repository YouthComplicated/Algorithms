package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-25 18:40
 * @version: 0.0.1
 */
public class Code_819 {

    /**
     *
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
     * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     *
     * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case
     * sensitive.  The answer is in lowercase.
     *
     *
     * Example:
     *
     * Input:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     *
     *
     * Note:
     *
     * 1 <= paragraph.length <= 1000.
     * 0 <= banned.length <= 100.
     * 1 <= banned[i].length <= 10.
     * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols,
     * and even if it is a proper noun.)
     * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     * There are no hyphens or hyphenated words.
     * Words only consist of letters, never apostrophes or other punctuation symbols.
     *
     *
     *  paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     *
     * 1、去除标点符号
     *
     * 2、使用map进行统计
     *
     *
     */

    public static String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>();
        String tempStr;
        String[] arr = paragraph.split("[ !?',;.]+");
        for(String str : arr){
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(Character.isLetter(chars[i])){
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
            tempStr = new String(chars);
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }
        for(String str : banned){
            map.remove(str);
        }
        map.remove("");
        int max = Integer.MIN_VALUE;
        String result = null;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;

    }

    /**
     * API 使用的相当6
     */
    public String mostCommonWord2(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String mostCommonWord3(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String str1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] arr1 = {"hit"};
//        System.out.println(mostCommonWord(str1, arr1));

        String str2 = "Bob. hIt, baLl";
        String[] arr2 = {"bob", "hit"};
        System.out.println(mostCommonWord(str2, arr2));



//        System.out.println(Arrays.toString(str1.split("\\!|\\?|'|,|\\.|;| ")));
    }





}