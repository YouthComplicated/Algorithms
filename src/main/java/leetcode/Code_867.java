package leetcode;

/**
 * @author: nj
 * @date: 2020-04-28 19:05
 * @version: 0.0.1
 */
public class Code_867 {

    /**
     *
     * Given a matrix A, return the transpose of A.
     *
     * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
     *
     * Example 1:
     *
     * Input: [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[1,4,7],[2,5,8],[3,6,9]]
     * Example 2:
     *
     * Input: [[1,2,3],[4,5,6]]
     * Output: [[1,4],[2,5],[3,6]]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 1000
     * 1 <= A[0].length <= 1000
     *
     *
     * 二维数组的遍历  横向与纵向遍历
     *
     */

    public static int[][] transpose(int[][] A) {
        if(A == null) {
            return  null;
        }
        int xLen = A.length, yLen = A[0].length;
        int[][] result = new int[yLen][xLen];

        for (int j = 0; j < A[0].length; j++) {
            for (int i = 0; i < A.length; i++) {
                result[j][i] = A[i][j];
            }
        }
        return A;
    }


    public static void main(String[] args) {

        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        arr1 = transpose(arr1);



    }

}