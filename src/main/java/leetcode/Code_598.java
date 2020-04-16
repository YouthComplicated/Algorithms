package leetcode;

/**
 * @author: nj
 * @date: 2020-04-15 17:40
 * @version: 0.0.1
 */
public class Code_598 {

    /**
     * Given an m * n matrix M initialized with all 0's and several update operations.
     *
     * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b,
     * which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
     *
     * You need to count and return the number of maximum integers in the matrix after performing all the operations.
     *
     * Example 1:
     * Input:
     * m = 3, n = 3
     * operations = [[2,2],[3,3]]
     * Output: 4
     * Explanation:
     * Initially, M =
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     *
     * After performing [2,2], M =
     * [[1, 1, 0],
     *  [1, 1, 0],
     *  [0, 0, 0]]
     *
     * After performing [3,3], M =
     * [[2, 2, 1],
     *  [2, 2, 1],
     *  [1, 1, 1]]
     *
     * So the maximum integer in M is 2, and there are four of it in M. So return 4.
     * Note:
     * The range of m and n is [1,40000].
     * The range of a is [1,m], and the range of b is [1,n].
     * The range of operations size won't exceed 10,000.
     *
     *
     * 二维数组
     *
     */

    public static int maxCount(int m, int n, int[][] ops) {
        if(ops == null){
            return 0;
        }
        int xSize = m, ySize = n;
        if(ops.length == 0){
            return xSize * ySize;
        }
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0] < xSize){
                xSize = ops[i][0];
            }
            if(ops[i][1] < ySize){
                ySize = ops[i][1];
            }
        }
        return xSize * ySize;

    }

    /**
     *
     * 看看这标准答案，很犀利，二维数组的遍历 66666  自己很low
     *
     */
    public int maxCount1(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
    
    
    
    


    public static void main(String[] args) {

        int[][] ops = {{2,2},{1,3}};
        System.out.println(maxCount(3,3, ops));

        int[][] ops1 = {};
        System.out.println(maxCount(3,3, ops1));

        int[][] ops2 = {{1,1}};
        System.out.println(maxCount(3,3, ops2));

//        System.out.println(ops2[0].length);
//        System.out.println(ops2.length);





    }




}