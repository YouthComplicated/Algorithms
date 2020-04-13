package leetcode;

/**
 * @author: nj
 * @date: 2020-04-11 09:16
 * @version: 0.0.1
 */
public class Code_507 {

    /**
     * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
     *
     * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     * Example:
     * Input: 28
     * Output: True
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     * Note: The input number n will not exceed 100,000,000. (1e8)
     *
     *
     * 分析 sum <= num  故必须找到所有因子并相加
     * 特殊情况，比如 因子相同
     *
     * 效率太低，寻找因子为加1操作，可以判断是否为偶数，排除一般的i++ 操作
     *
     *
     */

    public static boolean checkPerfectNumber(int num) {
        if(num == 1) {
            return false;
        }
        int sum = 1, temp;
        int space = 2;
        if(num % 2 != 0){
            space = 1;
        }
        for (int i = 2; i <= Math.sqrt(num); i += space) {
            if(num % i == 0){
                temp = num / i;
                if(i == temp){
                    sum += i;
                }else{
                    sum += i + temp;
                }
//                max = temp;
            }
        }
        return sum == num ? true : false;
    }


    /**
     * 纯数学的推导公式
     * @param p
     * @return
     */
    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public boolean checkPerfectNumber1(int num) {
        int[] primes = new int[] {2,3,5,7,13,17,19,31};
        for (int prime : primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {


        System.out.println(checkPerfectNumber(2));



    }










}