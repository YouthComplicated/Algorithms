package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-20 16:59
 * @version: 0.0.1
 */
public class Code_733 {

    /**
     *
     * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image
     * (from 0 to 65535).
     *
     * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel
     * value newColor, "flood fill" the image.
     *
     * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the
     * starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
     *
     * At the end, return the modified image.
     *
     * Example 1:
     * Input:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * Explanation:
     * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
     * by a path of the same color as the starting pixel are colored with the new color.
     * Note the bottom corner is not colored 2, because it is not 4-directionally connected
     * to the starting pixel.
     * Note:
     *
     * The length of image and image[0] will be in the range [1, 50].
     * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
     * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
     *
     *
     *
     * 递归的出口在哪里，如何设计递归的出口，
     */

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 上下左右试探
        int y = image.length, x = image[0].length;
        image[sr][sc] = newColor;
//        setColor(image, sr, sc, x, y, newColor, sr, sc);

        setColor(image,  sr - 1, sc, x, y, newColor, sr, sc);
        setColor(image,  sr + 1, sc, x, y, newColor, sr, sc);
        setColor(image, sr, sc - 1, x, y, newColor, sr, sc);
        setColor(image, sr, sc + 1, x, y, newColor, sr, sc);
        return image;
    }

    public static void setColor(int[][] image, int sr, int sc, int xLen, int yLen, int newColor, int tsr, int tsc) {
        System.out.println("sr:"+sr+"sc:"+sc);
        if (sr == tsr && sc == tsc) {
            System.out.println(111);
            return;
        }
        if (sr < 0 || sr > yLen - 1 || sc < 0 || sc > xLen - 1) {
            System.out.println(222);
            return;
        }
        if (image[sr][sc] == 0) {
            System.out.println(333);
            return;
        }
        if (image[sr][sc] == 1) {
            image[sr][sc] = newColor;
        }
        setColor(image,  sr - 1, sc, xLen, yLen, newColor, tsr, tsc);
        setColor(image,  sr + 1, sc, xLen, yLen, newColor, tsr, tsc);
        setColor(image, sr, sc - 1, xLen, yLen, newColor, tsr, tsc);
        setColor(image, sr, sc + 1, xLen, yLen, newColor, tsr, tsc);

        System.out.println(111);
        return ;
    }

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

    public static void main(String[] args) {

        int[][] arr1 = {{1,1,1},{1,1,0},{1,0,1}};
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }

        floodFill(arr1,1,1,2);

        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
        System.out.println(arr1);

    }


}