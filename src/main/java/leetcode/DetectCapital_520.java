package leetcode;

public class DetectCapital_520 {

    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     *
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     *
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     * Otherwise, we define that this word doesn't use capitals in a right way.
     *
     *
     * Example 1:
     *
     * Input: "USA"
     * Output: True
     *
     *
     * Example 2:
     *
     * Input: "FlaG"
     * Output: False
     *
     *
     * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     */


    public static boolean detectCapitalUse(String word) {

        if(word.length() == 1){
            return true;
        }
        boolean flag =  Character.isUpperCase(word.charAt(1));
        if(flag && Character.isUpperCase(word.charAt(0))){

        }
        for(int i = 2; i < word.length(); i++){
            if(flag && !Character.isUpperCase(word.charAt(i))){
                return false;
            }
            if(!flag && Character.isUpperCase(word.charAt(i))){
                return false;
            }

        }
        return true;

    }

    public static boolean detectCapitalUse1(String word) {
        if(word.length() == 1) {
            return true;
        }
        boolean isSecondLetterUpperCase = Character.isUpperCase(word.charAt(1));
        if(isSecondLetterUpperCase && !Character.isUpperCase(word.charAt(0))) return false;

        for(int i=2; i < word.length(); i++) {
            if(isSecondLetterUpperCase && !Character.isUpperCase(word.charAt(i))) {
                return false;
            }

            if(!isSecondLetterUpperCase && Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("u"));
        System.out.println(detectCapitalUse("ggg"));
        System.out.println(detectCapitalUse("leetcode"));
    }




}
