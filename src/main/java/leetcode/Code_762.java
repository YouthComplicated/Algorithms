package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-25 08:44
 * @version: 0.0.1
 */
public class Code_762 {

    /**
     * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits
     * in their binary representation.
     *
     * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example,
     * 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
     *
     * Example 1:
     *
     * Input: L = 6, R = 10
     * Output: 4
     * Explanation:
     * 6 -> 110 (2 set bits, 2 is prime)
     * 7 -> 111 (3 set bits, 3 is prime)
     * 9 -> 1001 (2 set bits , 2 is prime)
     * 10->1010 (2 set bits , 2 is prime)
     * Example 2:
     *
     * Input: L = 10, R = 15
     * Output: 5
     * Explanation:
     * 10 -> 1010 (2 set bits, 2 is prime)
     * 11 -> 1011 (3 set bits, 3 is prime)
     * 12 -> 1100 (2 set bits, 2 is prime)
     * 13 -> 1101 (3 set bits, 3 is prime)
     * 14 -> 1110 (3 set bits, 3 is prime)
     * 15 -> 1111 (4 set bits, 4 is not prime)
     * Note:
     *
     * L, R will be integers L <= R in the range [1, 10^6].
     * R - L will be at most 10000.
     *
     *
     * 暴力解题：
     *
     * 1、count bits
     * 2、isPrime
     *
     */

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for(int i = L; i <= R; i++){
            if(isPrime(Integer.bitCount(i))){
                result ++;
            }
        }
        return result;
    }


    private static boolean isPrime(int i){
        if(i < 2){
            return  false;
        }
        boolean isPrime = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     *
     * @param l
     * @param r
     * @return
     */
    public int countPrimeSetBits1(int l, int r) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)
                bits += n & 1;
            cnt += primes.contains(bits) ? 1 : 0;
        }
        return cnt;
    }



    public static void main(String[] args) {

        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(9));
    }





}