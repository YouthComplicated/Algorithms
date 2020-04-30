package leetcode;

/**
 * @author: nj
 * @date: 2020-04-30 19:44
 * @version: 0.0.1
 */
public class Code_925 {

    /**
     *
     * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed,
     * and the character will be typed 1 or more times.
     *
     * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some
     * characters (possibly none) being long pressed.
     *
     *
     * Example 1:
     *
     * Input: name = "alex", typed = "aaleex"
     * Output: true
     * Explanation: 'a' and 'e' in 'alex' were long pressed.
     * Example 2:
     *
     * Input: name = "saeed", typed = "ssaaedd"
     * Output: false
     * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
     * Example 3:
     *
     * Input: name = "leelee", typed = "lleeelee"   key:value()  l num ++
     * Output: true
     * Example 4:
     *
     * Input: name = "laiden", typed = "laiden"
     * Output: true
     * Explanation: It's not necessary to long press any character.
     *
     *
     * Constraints:
     *
     * 1 <= name.length <= 1000
     * 1 <= typed.length <= 1000
     * The characters of name and typed are lowercase letters.
     *
     *
     * 字母不连续、字母连续处理
     *
     * a  l  e   x
     *
     */
    public boolean isLongPressedName(String name, String typed) {

        char[] nameArr = name.toCharArray();
        char[] typeArr = typed.toCharArray();
        char prevChar;
        int j = 0, num = 1;
        boolean isSingle = true;
        for (int i = 0; i < nameArr.length - 1; i++) {
            if(nameArr[i] == nameArr[i+1]){
                isSingle = false;
            }
            //find num
            prevChar = nameArr[i];
            while (i + 1 < nameArr.length){
            }

            while (j < typeArr.length){
                if(prevChar == typeArr[j]){

                }
            }

        }



        return false;
    }


    public static void main(String[] args) {

    }


}