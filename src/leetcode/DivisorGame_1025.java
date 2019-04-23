package leetcode;

public class DivisorGame_1025 {
    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     *
     * Initially, there is a number N on the chalkboard.  On each player's turn,
     * that player makes a move consisting of:
     *
     * Choosing any x with 0 < x < N and N % x == 0.
     * Replacing the number N on the chalkboard with N - x.
     * Also, if a player cannot make a move, they lose the game.
     *
     * Return True if and only if Alice wins the game, assuming both players play optimally.
     *
     * Example 1:
     *
     * Input: 2
     * Output: true
     * Explanation: Alice chooses 1, and Bob has no more moves.
     *
     * Example 2:
     * Input: 3
     * Output: false
     * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
     *
     * Note:
     *
     * 1 <= N <= 1000
     */

    /**
     * 穷举法
     *
     * 每一步所有可能列出，然后进行计算，
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        int x = 1;
        while(N % x == 0){
            x++;
        }


        return false;
    }

    public static void main(String[] args) {

    }

}
