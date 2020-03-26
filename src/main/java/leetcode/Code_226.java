package leetcode;

/**
 * @author: nj
 * @date: 2020-03-15 20:11
 * @version: 0.0.1
 */
public class Code_226 {

    /**
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree
     * on a whiteboard so f*** off.
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp  = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(2);
        a3.left = a1;
        a3.right = a2;
        TreeNode a4 = new TreeNode(4);
        a4.left  = a3;
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(9);
        TreeNode a7 = new TreeNode(7);
        a7.left  = a5;
        a7.right = a6;
        a4.right = a7;


        invertTree(a4);
        System.out.println(1111);


    }





}