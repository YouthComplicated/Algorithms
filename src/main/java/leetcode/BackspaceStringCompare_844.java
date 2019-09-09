package leetcode;

import java.util.Arrays;

public class BackspaceStringCompare_844 {
    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     *
     * Example 1:
     *
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     *
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     *
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     *
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     * Note:
     *
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     */


    public static boolean  backspaceCompare(String S, String T) {
        char[] arr1 = S.toCharArray();
        char[] arr2 = T.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = arr1.length - 1; i >= 0; i--){
            if(arr1[i] == '#'){
                arr1[i] = ' ';
                for(int k = i - 1; k >= 0; k--){
                    if(arr1[k] != '#' && arr1[k] != ' '){
                        arr1[k] = ' ';
                        break;
                    }
                }
            }else if(arr1[i] != ' '){
                sb1.append(arr1[i]);
            }
        }

        for(int i = arr2.length - 1; i >= 0; i--){
            if(arr2[i] == '#'){
                arr2[i] = ' ';
                for(int k = i - 1; k >= 0; k--){
                    if(arr2[k] != '#' && arr2[k] != ' '){
                        arr2[k] = ' ';
                        break;
                    }
                }
            }else if(arr2[i] != ' '){
                sb2.append(arr2[i]);
            }
        }
//        System.out.println("sb1:"+sb1.toString()+"----sb2:"+sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {


        System.out.println(backspaceCompare("ab#c","ad#c"));
        System.out.println(backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare("a##c","#a#c"));
        System.out.println(backspaceCompare("a#c","b"));
    }
}
