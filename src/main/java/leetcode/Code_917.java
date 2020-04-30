package leetcode;

/**
 * @author: nj
 * @date: 2020-04-30 18:58
 * @version: 0.0.1
 */
public class Code_917 {

    /**
     * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
     * and all letters reverse their positions.
     *
     * Example 1:
     *
     * Input: "ab-cd"
     * Output: "dc-ba"
     * Example 2:
     *
     * Input: "a-bC-dEf-ghIj"
     * Output: "j-Ih-gfE-dCba"
     * Example 3:
     *
     * Input: "Test1ng-Leet=code-Q!"
     * Output: "Qedo1ct-eeLg=ntse-T!"
     *
     *
     * Note:
     *
     * S.length <= 100
     * 33 <= S[i].ASCIIcode <= 122
     * S doesn't contain \ or "
     */


    public static String reverseOnlyLetters(String S) {
        if(S == null){
            return S;
        }
        char[] chars = S.toCharArray();
        int start = 0, end = chars.length - 1;
        char temp;
        while (start < end){

            if(!Character.isLetter(chars[start])){
                while (start < end){
                    if(Character.isLetter(chars[start])){
                        break;
                    }
                    start ++;
                }
            }
            if(!Character.isLetter(chars[end])){
                while (end > start){
                    if(Character.isLetter(chars[end])){
                        break;
                    }
                    end --;
                }
            }
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start ++;
            end --;

        }

        return new String(chars);

    }

    public static void main(String[] args) {

        String str1 = "ab-cd";
//        System.out.println(reverseOnlyLetters(str1));


        //j-Ih-gfE-dCba
        String str2 = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(str2));

    }



}