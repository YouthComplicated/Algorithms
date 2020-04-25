package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-25 09:00
 * @version: 0.0.1
 */
public class Code_766 {

    /**
     * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
     *
     * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
     *
     *
     * Example 1:
     *
     * Input:
     * matrix = [
     *   [1,2,3,4],
     *   [5,1,2,3],
     *   [9,5,1,2]
     * ]
     * Output: True
     * Explanation:
     * In the above grid, the diagonals are:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
     * In each diagonal all elements are the same, so the answer is True.
     * Example 2:
     *
     * Input:
     * matrix = [
     *   [1,2],
     *   [2,2]
     * ]
     * Output: False
     * Explanation:
     * The diagonal "[1, 2]" has different elements.
     *
     * Note:
     *
     * matrix will be a 2D array of integers.
     * matrix will have a number of rows and columns in range [1, 20].
     * matrix[i][j] will be integers in range [0, 99].
     *
     * Follow up:
     *
     * What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of
     * the matrix into the memory at once?
     * What if the matrix is so large that you can only load up a partial row into the memory at once?
     *
     *
     * 如果数组过大，延迟加载问题处理
     *
     *
     * 每次加载两行，两两比较
     *
     * 优化 只加载第一行，之后元素每次加载与第一行作比较，此种方案不可行的
     *
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int xLen = matrix.length, yLen = matrix[0].length;
        for (int x = 1; x < xLen; x++) {
            for (int y = 1; y < yLen; y++) {
                if(matrix[x][y] != matrix[x-1][y-1]){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(isToeplitzMatrix(arr1));


        int[][] arr2 = {
                {1,2},
                {2,4}
        };
        System.out.println(isToeplitzMatrix(arr2));



//        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(Arrays.toString(arr1[i]));
//        }
//        System.out.println(arr1[0][1]);
//        System.out.println(arr1[1][0]);

    }







}