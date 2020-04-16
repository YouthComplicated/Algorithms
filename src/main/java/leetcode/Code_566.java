package leetcode;

import base.Arrays.Array;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-15 10:29
 * @version: 0.0.1
 */
public class Code_566 {

    /**
     * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
     * size but keep its original data.
     *
     * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the
     * row number and column number of the wanted reshaped matrix, respectively.
     *
     * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order
     * as they were.
     *
     * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
     * output the original matrix.
     *
     * Example 1:
     * Input:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * Output:
     * [[1,2,3,4]]
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the
     * previous list.
     * Example 2:
     * Input:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 2, c = 4
     * Output:
     * [[1,2],
     *  [3,4]]
     * Explanation:
     * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
     * Note:
     * The height and width of the given matrix is in range [1, 100].
     * The given r and c are all positive.
     *
     *
     * 二维数组转换为给定的维度的数组
     *
     *
     */

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null){
            return null;
        }
        int reShapeSize = r * c;
        int xLen = nums.length, yLen = nums[0].length;
        int size = xLen * yLen;
        if(reShapeSize  != size){
            return nums;
        }
        int[][] matrixReshape = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrixReshape[i][j] = nums[x][y];
                if( ++y == yLen){
                    y = 0;
                    x++;
                }
            }
        }
        return matrixReshape;

    }




    public static void main(String[] args) {

        int [][] nums = {{1,2},{3,4}};
        print(nums);
        print(matrixReshape(nums, 1,4));

        int [][] nums1 = {{1,2,5},{3,4,8}};
        System.out.println("x:" + nums1.length+"y:" + nums1[0].length);

    }


    public static void  print(int[][] nums){
        int r = nums.length, c = nums[0].length;
        for (int i = 0; i < r; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }




    }


















}