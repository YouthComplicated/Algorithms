package leetcode;

/**
 * @author: nj
 * @date: 2020-03-31 15:22
 * @version: 0.0.1
 */
public class Code_463 {


    /**
     *
     *
     * 给定一个值，上下左右如果有减去1
     *
     * 有重复计算的值
     *
     *
     */

    public static int islandPerimeter(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int num = 0, increase = 0, xLen = grid.length, yLen = grid[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(grid[i][j] == 1 ){
                    num += 4;
                    //up
                    if(j - 1 >= 0 && grid[i][j-1] == 1){
                        increase ++;
                    }
                    //down
                    if(j + 1 < yLen  && grid[i][j+1] == 1){
                        increase ++;
                    }
                    //left
                    if(i - 1 >=0 && grid[i-1][j] == 1){
                        increase ++;
                    }
                    //right
                    if(i + 1 < xLen && grid[i+1][j] == 1){
                        increase ++;
                    }
                }
            }
        }
        return num - increase;
    }

    /**
     *
     * @param grid
     * @return
     */
    public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1){
                        neighbours++; // count down neighbours
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1){
                        neighbours++; // count right neighbours
                    }
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }


    public static void main(String[] args) {


//        System.out.println(1^1);
//        System.out.println(1^0^1);
//        System.out.println(1^1^0^1);
//        System.out.println(1^1^1^1);


        int[][] arr1 = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};

        System.out.println(islandPerimeter(arr1));

        int[][] arr2 = {{0,1,0,0}};
        System.out.println(islandPerimeter(arr2));

    }

}