package leetcode;

public class FibonacciNumber_509 {

    /**
     *
     * The Fibonacci numbers, commonly denoted F(n) form a sequence,
     * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
     * starting from 0 and 1. That is,
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), for N > 1.
     * Given N, calculate F(N).
     *
     *
     *
     * Example 1:
     *
     * Input: 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     * Example 2:
     *
     * Input: 3
     * Output: 2
     * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     * Example 3:
     *
     * Input: 4
     * Output: 3
     * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     *
     *
     * Note:
     *
     * 0 ≤ N ≤ 30.
     *
     * Accepted
     * 76,188
     * Submissions
     * 114,367
     */


    //递归方法
    public static int fib(int N) {
        if(N <= 1){
            return N;
        }
        return fib(N - 1)+fib(N - 2);
    }

    //累加的过程， 逻辑单一，没有太多分支
    public static int fib1(int N) {

        if (N<=1){
            return N;
        }
        int a = 0;
        int b = 1;
        while(N-- >1){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));

    }




}
