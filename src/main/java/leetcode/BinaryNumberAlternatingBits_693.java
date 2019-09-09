package leetcode;

public class BinaryNumberAlternatingBits_693 {


    /**
     * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
     *
     * Example 1:
     * Input: 5
     * Output: True
     * Explanation:
     * The binary representation of 5 is: 101
     * Example 2:
     * Input: 7
     * Output: False
     * Explanation:
     * The binary representation of 7 is: 111.
     * Example 3:
     * Input: 11
     * Output: False
     * Explanation:
     * The binary representation of 11 is: 1011.
     * Example 4:
     * Input: 10
     * Output: True
     * Explanation:
     * The binary representation of 10 is: 1010.
     */


    public static boolean hasAlternatingBits(int n) {
        int i = n % 2;
        n = n / 2;
        while (n != 0){
            if(n % 2 == i){
                return false;
            }
            i = n % 2;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
    }
}
