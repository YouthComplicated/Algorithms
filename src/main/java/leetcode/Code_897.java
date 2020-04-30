package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-30 10:57
 * @version: 0.0.1
 */
public class Code_897 {

    /**
     * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of
     * the tree, and every node has no left child and only 1 right child.
     *
     * Example 1:
     * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
     *
     *        5
     *       / \
     *     3    6
     *    / \    \
     *   2   4    8
     *  /        / \
     * 1        7   9
     *
     * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     *
     *  1
     *   \
     *    2
     *     \
     *      3
     *       \
     *        4
     *         \
     *          5
     *           \
     *            6
     *             \
     *              7
     *               \
     *                8
     *                 \
     *                  9
     *
     * Constraints:
     *
     * The number of nodes in the given tree will be between 1 and 100.
     * Each node will have a unique integer value from 0 to 1000.
     *
     *
     * 二叉树  左根右遍历  然后重新构造符合题意的构造树
     */


    TreeNode curr;
    public  TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inOrder(root);
        return ans.right;
    }

    public  void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inOrder(root.right);
    }

    TreeNode cur;
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public TreeNode increasingBST2(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }


    public static void main(String[] args) {

        TreeNode binTree = TreeNodeUtils.createBinTree(Arrays.asList(5,3,6,2,4,null,8,1,null,null,null,null,null,7,9));


        Code_897 code897 = new Code_897();

        TreeNode node = code897.increasingBST1(binTree);

        System.out.println(11);

    }

}