package leetcode;

/**
 * @author: nj
 * @date: 2020-03-14 11:15
 * @version: 0.0.1
 */
public class Code_190 {

    /**
     * 190. Reverse Bits
     * Reverse bits of a given 32 bits unsigned integer.
     *
     *
     * Example 1:
     *
     * Input: 00000010100101000001111010011100
     * Output: 00111001011110000010100101000000
     * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
     * so return 964176192 which its binary representation is 00111001011110000010100101000000.
     * Example 2:
     *
     * Input: 11111111111111111111111111111101
     * Output: 10111111111111111111111111111111
     * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
     * so return 3221225471 which its binary representation is 10111111111111111111111111111111.
     *
     *
     * Note:
     *
     * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output
     * will be given as signed integer type and should not affect your implementation, as the internal binary representation
     * of the integer is the same whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the
     * input represents the signed integer -3 and the output represents the signed integer -1073741825.
     */

    public static int reverseBits(int n) {
        return Integer.reverseBytes(n);
    }


    public static int reverseBitsA(int n){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int rightbit = n & 1;
            n = n >> 1;
            res = i < 31 ? (res | rightbit) << 1 : (res | rightbit);
            System.out.println("rightBit:"+rightbit+"n:"+n+"res:"+res);
        }
        return res;
    }


    public static int reverseBitsA1(int n){
        int r=0;
        int i=32;
        while (i!=0) {
            r =(r<<1)|(n&1);
            n >>= 1;
            i--;
        }
        return r;
    }

    public static int reverseBitA2(int n){
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.reverse(964176192));
//        int i = Integer.parseUnsignedInt("4294967293");
//        System.out.println(Integer.reverse(i));
//        System.out.println(Integer.reverse(-3));
//        System.out.println(reverseBits(4294967293));


//        System.out.println(1|1);
//        System.out.println(1|0);
//        System.out.println(reverseBitsA(3));

        System.out.println(0xff00ff00);




    }

}