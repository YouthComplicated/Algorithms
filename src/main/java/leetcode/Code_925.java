package leetcode;

import java.util.ArrayList;
import java.util.List;

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
    public static boolean isLongPressedName(String name, String typed) {

        char[] nameArr = name.toCharArray();
        char[] typeArr = typed.toCharArray();
        if(nameArr[0] != typeArr[0]){
            return false;
        }
        int j = 1, i = 1, repeatNum, checkNum;
        for ( ; i < nameArr.length && j < typeArr.length ; i++,j++) {
            if(nameArr[i] != typeArr[j]){
                return false;
            }
            repeatNum = checkNum = 1;
            while (i < nameArr.length){
                if(nameArr[i] != nameArr[i-1]){
                    break;
                }
                i++;
                repeatNum ++;
            }
            while (j < typeArr.length){
                if(typeArr[j] != typeArr[j - 1]){
                    break;
                }
                j++;
                checkNum ++;
            }
            if(repeatNum > checkNum){
                return false;
            }
        }

        System.out.println("i:" + i+" j:" + j);
        if(i != nameArr.length){
          return false;
        }

        while (j < typeArr.length){
            if(typeArr[j] != nameArr[i]){
                return false;
            }
            j++;
        }
        return true;
    }


    /**
     *
     * 构造相应的结构去表示
     *
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName1(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i+1;
            }
        }

        return new Group(key.toString(), count);
    }

    /**
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName2(String name, String typed) {
        if(name.length() == typed.length()) return true;

        if(name.length() > typed.length()) return false;

        int j = 0;
        int i = 0;

        //通过两个下标进行循环
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j))
                i += 1;
            else if(j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                //连续
                return false;

            j += 1;
        }

        return (i == name.length());
    }




    public static void main(String[] args) {

//
//        System.out.println(isLongPressedName("alex", "aaleex"));
//        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
//        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("pyplrz", "ppyypllrzzzzz"));


    }


}

class Group {
    String key;
    List<Integer> count;

    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
}