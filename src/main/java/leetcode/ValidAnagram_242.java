package leetcode;

public class ValidAnagram_242 {

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     */
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        /**
         * a-z  97-122
         */
        char[] a = new char[26];
        char[] b = new char[26];

        for(int i = 0; i < s.length(); i++){
            a[s.charAt(i) - 97] ++;
            b[t.charAt(i) - 97] ++;
        }
        for(int i= 0; i < 26; i++){
            if(a[i] !=  b[i]){
                return false;
            }
        }
        return true;

    }

    public static boolean isAnagram1(String s, String t) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c-'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

//        char a = 'z';
//        char b = 'a';
//        System.out.println((int)a+","+(int)b);

        System.out.println(ValidAnagram_242.isAnagram("anagram","nagaram"));
        System.out.println(ValidAnagram_242.isAnagram("rat","car"));


    }
}
