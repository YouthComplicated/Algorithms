package leetcode;

public class PowerofTwo_231 {

    /**
     * Given an integer, write a function to determine if it is a power of two.
     *
     * Example 1:
     *
     * Input: 1
     * Output: true
     * Explanation: 20 = 1
     * Example 2:
     *
     * Input: 16
     * Output: true
     * Explanation: 24 = 16
     * Example 3:
     *
     * Input: 218
     * Output: false
     */

    public static boolean isPowerOfTwo(int n) {
        for(;;){
            if(n == 1){
                return true;
            }else if(n != 0 && n % 2 == 0){
                n = n / 2;
            }else{
                return false;
            }
        }
    }


    public static boolean isPowerOfTwo1(int n) {
        return n>0 && ((n&(n-1))==0);
    }

    public static void main(String[] args) {
        System.out.println(PowerofTwo_231.isPowerOfTwo(1));
        System.out.println(PowerofTwo_231.isPowerOfTwo(16));
        System.out.println(PowerofTwo_231.isPowerOfTwo(218));
    }
}
