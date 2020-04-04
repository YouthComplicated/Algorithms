package leetcode;

/**
 * @author: nj
 * @date: 2020-03-31 20:27
 * @version: 0.0.1
 */
public class Code_476 {

    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary
     * representation.
     *
     *
     *
     * Example 1:
     *
     * Input: 5
     * Output: 2
     * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
     *
     *
     * Example 2:
     *
     * Input: 1
     * Output: 0
     * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
     *
     *
     * Note:
     *
     * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
     * You could assume no leading zero bit in the integer’s binary representation.
     * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
     *
     *
     * 如果确定最高位
     *
     *
     */


    public static int findComplement(int num) {
        int tmp = num;
        int num2 = 1;
//        System.out.println(Integer.toBinaryString(tmp));
        while(tmp > 0){
            num2 <<= 1;
            tmp >>= 1;
//            System.out.println("num2:"+Integer.toBinaryString(num2));
//            System.out.println("temp:"+Integer.toBinaryString(tmp));
        }
        num2 -= 1;
        return num^num2;
    }

    public int findComplement1(int num) {
        int idx = 31, mask = (1 << idx);
        // find the leftmost one
        while((num & mask) == 0) {
            mask = (1 << idx);
            idx--;
        }
        mask = (mask << 1) - 1;
        return (~num & mask);
    }

    public static void main(String[] args) {

//        System.out.println(Integer.reverseBytes(5));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(1<<31);
        //1000 0000 0000 0000 0000 0000 0000 0000
        System.out.println(Integer.toBinaryString(1<<31));

        System.out.println((1<<31) + 1);
        System.out.println(Integer.toBinaryString(1<<32));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));


        System.out.println(findComplement(5));


    }







}