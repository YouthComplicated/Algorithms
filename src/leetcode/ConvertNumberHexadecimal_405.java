package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertNumberHexadecimal_405 {


    /**
     * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
     *
     * Note:
     *
     * All letters in hexadecimal (a-f) must be in lowercase.
     * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
     * The given number is guaranteed to fit within the range of a 32-bit signed integer.
     * You must not use any method provided by the library which converts/formats the number to hex directly.
     * Example 1:
     *
     * Input:
     * 26
     *
     * Output:
     * "1a"
     * Example 2:
     *
     * Input:
     * -1
     *
     * Output:
     * "ffffffff"
     *
     *
     *
     *
     * 负数转换需要补码的参与
     *
     *
     * 负数转换成二进制分为3步：
     * 1、首先将负数转换为对应的原码
     * -3的原码为(也就是+3转换成二进制后的字符串)：
     * 0000 0000 0000 0000 0000 0000 0000 0011
     *
     * 2、再将原码的每一位做取反操作得到反码。   取反操作：0变为1     1变为0；  取反后的结果即为：
     * 1111 1111 1111 1111 1111 1111 1111 1100
     *
     * 3、将反码+1得到补码
     * 1111 1111 1111 1111 1111 1111 1111 1101
     *
     *
     * 负数转换成八进制、十六进制，只需在补码(二进制)的基础上，3位合成一位计算，或者4位合成一位计算
     * -3的转换成二进制为：
     *
     * 1111 1111 1111 1111 1111 1111 1111 1101
     * 八进制则将-3的二进制从右至左每3位为一个单元，不够三位用0补 即：
     *
     * 011 111 111 111 111 111 111 111 111 111 101
     * 计算每一个单元，结果为：37777777775
     *
     * 十六进制则将-3的二进制从右至左每4位合并为一个单元，即：
     * 1111 1111 1111 1111 1111 1111 1111 1101
     * 计算后为： FFFFFFFD
     */

    private  static  final char [] HEXARR = {
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };

    public static String toHex(int num) {

        List<Character> list = new ArrayList<>();
        while (num != 0){
            list.add(HEXARR[num%16]);
            num /= 16;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
        }
        return sb.toString();
    }


    public static String toHex1(int num) {
        /**
         * 记录数与15的与运算结果，求得原数二进制最后四位的值
         * 若数的二进制不止四位,除去后四位的新数
         */
        if (num == 0) {
            return "0";
        }
        // = 0b1111
        final int MASK_LAST_FOUR_BITS = 0x00_00_00_0f;
        final StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int lastFourBits = num & MASK_LAST_FOUR_BITS;
            sb.append(HEXARR[lastFourBits]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(toHex(26));
        System.out.println(toHex(16));
        System.out.println(toHex(17));

//        System.out.println(toHex(-1));

        System.out.println(Integer.toHexString(26));
    }







}

