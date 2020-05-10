package leetcode;

/**
 * @author: nj
 * @date: 2020-05-09 09:53
 * @version: 0.0.1
 */
public class Code_999 {

    /**
     *
     * @param board
     * @return
     */
    
    public static int numRookCaptures(char[][] board) {
        int i = 0, j =  0;
        boolean isFind = false;
        for (; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R'){
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                break;
            }
        }

        int ans = 0;
        //up  down  left right
        int up = i - 1;
        while (up >= 0){
            if(board[up][j] == 'B'){
                break;
            }else if(board[up][j] == 'p'){
                ans += 1;
                break;
            }
            up --;
        }

        int down = i + 1;
        while (down < board.length){
            if(board[down][j] == 'B'){
                break;
            }else if(board[down][j] == 'p'){
                ans += 1;
                break;
            }
            down ++;
        }

        int left = j - 1;
        while (left >= 0){
            if(board[i][left] == 'B'){
                break;
            }else if(board[i][left] == 'p'){
                ans += 1;
                break;
            }
            left --;
        }


        int right = j + 1;
        while (right < 8){
            if(board[i][right] == 'B'){
                break;
            }else if(board[i][right] == 'p'){
                ans += 1;
                break;
            }
            right ++;
        }

        return ans;
    }


    public static void main(String[] args) {
        char[][] arr = {{'.','.','.','.','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','R','.','.','.','p'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'}};


        System.out.println(numRookCaptures(arr));



    }

}