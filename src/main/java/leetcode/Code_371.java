package leetcode;

/**
 * @author: nj
 * @date: 2020-03-25 21:11
 * @version: 0.0.1
 */
public class Code_371 {
    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     * Example 1:
     *
     * Input: a = 1, b = 2
     * Output: 3
     * Example 2:
     *
     * Input: a = -2, b = 3
     * Output: 1
     *
     *
     * 不使用加号，减号，来实现求两个整数的和。
     *
     * 利用到：
     *
     * ①异或：完成相加但不进位。
     *
     * ②与运算计算出哪些地方需要进位，在通过左移运算（<<）完成进位操作。
     *
     * 这样①+②就是所得结果。如果相加依旧有进位，则接着如上操作，这样就构成了一个递归操作。
     *
     *
     */

    public int getSum(int a, int b) {
            if (b == 0) {
                return a;
            }
            int c = a ^ b;
            int d = (a & b) << 1;
            return getSum(c, d);
    }

    public int getSum1(int a, int b) {
        while(b != 0) {
            int sum = a^b;
            int carrier = (a&b)<<1;
            a = sum;
            b = carrier;
        }
        return a;
    }

}