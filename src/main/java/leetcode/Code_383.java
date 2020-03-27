package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 08:18
 * @version: 0.0.1
 */
public class Code_383 {

    /**
     *
     * Given an arbitrary ransom note string and another string containing letters from all the magazines,
     * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     *
     * Each letter in the magazine string can only be used once in your ransom note.
     *
     * Note:
     * You may assume that both strings contain only lowercase letters.
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     *
     * 字符串匹配问题
     *
     * 1、细节问题  是否为空
     * 2、字符串经常涉及转换为char数组，此时得考虑一下"" 空数组的情况
     *
     *
     * 有顺序的匹配，但改题是只要出现就满足题目意思
     *
     */


    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null ){
            return false;
        }
        char[] dictionaryArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();
        int dictIndex = 0, magazineIndex = 0;
        int dicLen = dictionaryArr.length, mLen = magazineArr.length;
        if(dicLen == 0){
            return true;
        }
        for (int i = 0; i < magazineArr.length; i++) {
            magazineIndex = i;
            while (magazineArr[magazineIndex++] == dictionaryArr[dictIndex++]){
                if(dictIndex == dictionaryArr.length){
                    return true;
                }
                if(magazineIndex == magazineArr.length){
                    return false;
                }
            }
            dictIndex = 0;
        }
        return false;

    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        /**
         * o(n*n)
         */
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1){
                return false;
            }
            caps[c - 97] = index + 1;
        }
        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] a1 = new int[26];

        for(int i = 0; i < ransomNote.length(); i++) {
            a[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0; i < magazine.length(); i++) {
            a1[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(a[i]>a1[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(canConstruct("a","b"));
//        System.out.println(canConstruct("aa","ab"));
//        System.out.println(canConstruct("aa","aab"));
//        System.out.println(canConstruct("abc","aaabthattabc"));
        System.out.println(canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
        System.out.println(canConstruct("","a"));
        System.out.println(canConstruct("",""));



    }



}