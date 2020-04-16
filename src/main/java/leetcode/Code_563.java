package leetcode;

/**
 * @author: nj
 * @date: 2020-04-12 16:40
 * @version: 0.0.1
 */
public class Code_563 {

    /**
     * Given a binary tree, return the tilt of the whole tree.
     *
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and
     * the sum of all right subtree node values. Null node has tilt 0.
     *
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     *
     * Example:
     * Input:
     *          1
     *        /   \
     *       2     3
     * Output: 1
     * Explanation:
     * Tilt of node 2 : 0
     * Tilt of node 3 : 0
     * Tilt of node 1 : |2-3| = 1
     * Tilt of binary tree : 0 + 0 + 1 = 1
     * Note:
     *
     * The sum of node values in any subtree won't exceed the range of 32-bit integer.
     * All the tilt values won't exceed the range of 32-bit integer.
     *
     *   1
     *  /
     *  2
     *
     *  0 + 2 - 0  = 2
     *
     *  注意是所有子树的的left(sum) - right(sum)
     *
     *
     *  [1,2,3,4,null,5] is 10 or  11
     *
     *              1
     *             /  \
     *            2    3
     *          /     /
     *         4     5
     *
     *
     *
     *       1 ( t = 4+5 + abs(2+4 - 3-5) = 11)                        ^
     *     2  (t = 4-0 = 4)             3 ( t = 5-0 = 0)                                |
     *  4 (t =0 -0 = 0)           5 (t = 0 - 0 = 0)                                      |
     */


    /**
     *
     */
    static int sum = 0;
    public static int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
//        System.out.println(root.val);

        /**
         * 以下是节点的左右相加
         */
        sum += Math.abs((root.left == null ? 0 : root.left.val)
                - (root.right == null ? 0 : root.right.val));
        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }


    public static int findTilt1(TreeNode root) {
        if(root == null){
            return 0;
        }

        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }


    public static void main(String[] args) {

//        TreeNode a1 = new TreeNode(1);
//        TreeNode a2 = new TreeNode(2);
//        TreeNode a3 = new TreeNode(3);
//        TreeNode a4 = new TreeNode(8);
//        TreeNode a5 = new TreeNode(2);
//        a1.left = a2;
//        a1.right = a3;
//        a2.left = a4;
//        a2.right = a5;
//        System.out.println(findTilt1(a1));

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        a1.left = a2;
        System.out.println(findTilt1(a1));



    }
}