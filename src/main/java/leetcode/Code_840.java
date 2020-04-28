package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-28 15:44
 * @version: 0.0.1
 */
public class Code_840 {

    /**
     * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column,
     * and both diagonals all have the same sum.
     *
     * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
     *
     *
     *
     * Example 1:
     *
     * Input: [[4,3,8,4],
     *         [9,5,1,9],
     *         [2,7,6,2]]
     * Output: 1
     * Explanation:
     * The following subgrid is a 3 x 3 magic square:
     * 438
     * 951
     * 276
     *
     * while this one is not:
     * 384
     * 519
     * 762
     *
     * In total, there is only one magic square inside the given grid.
     * Note:
     *
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     *
     * 0 <= grid[i][j] <= 15  使用数组代替hashSet
     *
     *
     *
     * 注意的坑：必需填满1-9数字
     *
     */
    public static int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                //判断是否为gird
                if(isMagic(grid[i][j],grid[i][j+1],grid[i][j+2],
                        grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2],
                        grid[i+2][j],grid[i+2][j+1],grid[i+2][j+2]
                        )){
                    ans ++;
                }
            }
        }
        return ans;
    }

    /**
     * 枚举所有的8种可能
     * @return
     */
    public static boolean isMagic(int a,int b, int c, int d, int e, int f, int g, int h, int i){
        //判断是否为1-9
        Set<Integer> set = new HashSet<>();
        if((a < 1 || a > 9) || (b < 1 || b > 9)  || (c < 1 || c > 9)
            ||(d < 1 || d > 9) || (e < 1 || e > 9)  || (f < 1 || f > 9)
                ||(g < 1 || g > 9) || (h < 1 || h > 9)  || (i < 1 || i > 9)){
            return  false;
        }
        set.add(a);set.add(b);set.add(c);set.add(d);set.add(e);set.add(f);set.add(g);set.add(h);set.add(i);
        if(set.size() != 9){
            return false;
        }
        int sum = a + b + c;
        if(sum != d + e + f){
            return false;
        }

        if(sum != g + h + i){
            return false;
        }


        if(sum != a + d + g){
            return false;
        }

        if(sum != b + e + h){
            return false;
        }

        if(sum != c + f + i){
            return false;
        }

        if(sum != a + e + i){
            return false;
        }
        if(sum != c + e + g){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] arr = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(arr));
    }




}