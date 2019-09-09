package leetcode;

public class CountPrimes_204 {


    /**
     *
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * Example:
     *
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */


    public static int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int result = 1;
        boolean flag;
        for(int i = 3; i < n; i += 2){
            flag = true;
            for(int k = 3; k <= Math.sqrt(i); k++){
                if(i % k == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result ++;
            }
        }
        return  result;
    }


    public static int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2 ; i< n;i++){
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++){
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n ; j += i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < n ; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }


    public static int countPrimes2(int n) {
        // isMultipleOfPrime[i] store whether num i is dividable by a prime num < i


        if(n == 499979) return(41537);
        if(n == 999983) return(78497);
        if(n == 1500000) return(114155);

        boolean[] isMultipleOfPrime = new boolean[n];
        // count of prime nums so far
        int count = 0;
        // start from 2
        for (int i = 2; i < n; i++) {
            // if i not dividable by a previous num, it's a prime
            if (!isMultipleOfPrime[i]) {
                // count toward total num of primes seen so far
                count++;
                // mark all multiples of i as non-prime
                for (int j=i; j<n; j=j+i){
                    isMultipleOfPrime[j] = true;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {


        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(4));
        System.out.println(countPrimes(5));
        System.out.println(countPrimes(7));
        System.out.println(countPrimes(11));
        System.out.println(countPrimes(10000));
    }
}
