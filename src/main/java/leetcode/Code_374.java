package leetcode;

/**
 * @author: nj
 * @date: 2020-03-25 21:18
 * @version: 0.0.1
 */
public class Code_374 {

    /**
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked.
     *
     * Every time you guess wrong, I'll tell you whether the number is higher or lower.
     *
     * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
     *
     * -1 : My number is lower
     *  1 : My number is higher
     *  0 : Congrats! You got it!
     *
     */


    public int guessNumber(int n) {
        int left = 1, right = n;
        int temp,middle;
        while (left <= right){
            middle = left + (right - left) / 2;
            temp = guess(middle);
            if (temp == 0) {
                return middle;
            }else if(temp == -1){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }

    public int guessNumber11(int n) {
        //lets do a binary search
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2, check = guess(mid);
            if (check == 0)
                return mid;
            else if (check == -1)
                right = mid - 1;
            else
                left = mid + 1;
        }

        throw new IllegalArgumentException("Invalid n: " + n);
    }

    int guess(int num){
        return 0;
    }
}