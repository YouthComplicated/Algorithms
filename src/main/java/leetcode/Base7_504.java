package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Base7_504 {


    /**
     *
     * Given an integer, return its base 7 string representation.
     *
     * Example 1:
     * Input: 100
     * Output: "202"
     * Example 2:
     * Input: -7
     * Output: "-10"
     * Note: The input will be in range of [-1e7, 1e7].
     */

    public static String convertToBase7(int num) {
        List<Integer> list = new ArrayList<>();
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if(num < 0){
            sb.append("-");
        }
        while(num != 0){
            list.add(num % 7);
            num = num / 7;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(Math.abs(list.get(i)));
        }
        return sb.toString();
    }


    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public String convertToBase71(int i) {
        char buf[] = new char[33];

        boolean negative = (i < 0);
        int charPos = 32;

        if (negative) {
            i = -i;
        }

        int radix = 7;

        while (i >= radix) {
            buf[charPos--] = digits[(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));

    }


    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(-8));
        System.out.println(convertToBase7(11));
    }


}
