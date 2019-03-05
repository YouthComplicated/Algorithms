package leetcode;


public class LengthofLastWord_58 {


    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     *
     * If the last word does not exist, return 0.
     *
     * Note: A word is defined as a character sequence consists of non-space characters only.
     *
     * Example:
     *
     * Input: "Hello World"
     * Output: 5
     */

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for(int i = chars.length - 1 ; i >= 0; i--){
            if(chars[i] == ' '){
                if(j > 0){
                    return j;
                }
            }else{
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
//        String str = "aa bb vv  ";
//        System.out.println(Arrays.toString(str.split(" ")));

        LengthofLastWord_58 list = new LengthofLastWord_58();
        System.out.println(list.lengthOfLastWord("Hello World"));
        System.out.println(list.lengthOfLastWord("a "));

    }
}
