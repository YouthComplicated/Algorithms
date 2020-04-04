package leetcode;

/**
 * @author: nj
 * @date: 2020-03-31 14:42
 * @version: 0.0.1
 */
public class Code_461 {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     *
     * Given two integers x and y, calculate the Hamming distance.
     *
     * Note:
     * 0 ≤ x, y < 231.
     *
     * Example:
     *
     * Input: x = 1, y = 4
     *
     * Output: 2
     *
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * The above arrows point to positions where the corresponding bits are different.
     *
     *
     * 求二进制不同的位数
     *
     */

    public static int  hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++){
            count += (xor >> i) & 1;
        }
        return count;
    }




    public static void main(String[] args) {


        System.out.println(1 ^ 8);
        System.out.println(Integer.bitCount(9));

        System.out.println(hammingDistance(4, 4));
        System.out.println(hammingDistance(1, 8));
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(8, 3));

    }



















}