package leetcode;

import org.junit.Test;

/**
 * @author NJ
 * @date 2018/10/24 16:36
 */
public class pow_fifty {


    /**
     * Note:
     -100.0 < x < 100.0
     n is a 32-bit signed integer, within the range [−231, 231 − 1]
     */

    /**
     * java 使用位运算实现加减乘除
     *
     * @param args
     */

    public static void main(String[] args) {


        System.out.println(new Solution().myPow(2.0, 2));
        System.out.println(new Solution().myPow(2.10000, 3));
        System.out.println(new Solution().myPow(2.00000, -2));
        System.out.println(new Solution().myPow(0.44528, 0));

    }

    @Test
    public void Test1(){
        long time = System.currentTimeMillis();
        int a = 100;
        for(int i=0;i<100000000;i++){
            // 向高位移动一位，相当于乘以 2 的1次方
            a<<=1;
            // 向低位移动一位，相当于 除以 2的 1次方
            a>>=1;
        }
        System.out.println("耗时：" + (System.currentTimeMillis()- time));
    }

    @Test
    public void Test2(){
        long time = System.currentTimeMillis();
        int a = 100;
        for(int i=0;i<100000000;i++){
            a *=2;
            a /=2;
        }
        System.out.println("耗时：" + (System.currentTimeMillis()- time));
    }


    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1.0;
            }
            int a = Math.abs(n);
            double result = x;
            while (--a > 0) {
                result *= x;
            }
            if (n < 0) {
                result = 1 / result;
            }
            return result;
        }

        public double secondPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                return 1 / (x * myPow(x, -(n+1)));
            } else {
                double temp = myPow(x * x , n / 2);
                return (n % 2 == 0) ? temp : x * temp;
            }
        }

        public double fasterPow(double x, int n) {
            if (n < 0) {
                if (x == -1) {
                    return n % 2 == 0 ? 1 : -1;
                }
                if (n == Integer.MIN_VALUE) {
                    n = -Integer.MAX_VALUE;
                }
                x = 1 / x;
                n = -n;
            }
            if (n == 0) {
                return 1;
            } else if (n % 2 == 0) {
                double y = myPow(x, n / 2);
                return y * y;
            } else {
                return x * myPow(x, n - 1);
            }
        }

        /**
         * The basic idea is to decompose the exponent into powers of 2,
         * so that you can keep dividing the problem in half. For example, lets say
         * N = 9 = 2^3 + 2^0 = 1001 in binary. Then: x^9 = x^(2^3) * x^(2^0)
         * We can see that every time we encounter a 1 in the binary representation of N,
         * we need to multiply the answer with x^(2^i) where i is the ith bit of the exponent. Thus,
         * we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it
         * by the answer when we see a 1.
         * To handle the case where N=INTEGER_MIN we use a long (64-bit) variable.
         */
        public double pow1(double x, int n) {
            double ans = 1;
            long abs = Math.abs((long) n);
            while(abs > 0)
            {
                if((abs & 1) == 1)
                {
                    ans *= x;
                }
                abs >>= 1;
                x *= x;
            }
            return n < 0 ? 1/ans : ans;
        }
    }
}
