package leetcode;

/**
 * @author: nj
 * @date: 2020-04-11 17:18
 * @version: 0.0.1
 */
public class Code_538 {

    /**
     *
     *
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
     * the original key plus sum of all keys greater than the original key in BST.
     *
     * Example:
     *
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     *
     *
     * 寻找某个节点下所有节点的最大值
     *
     *
     */
    private int sum = 0;



    public TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.right);
            sum += root.val;
            root.val = sum;
            convertBST1(root.left);

        }
        return root;
    }


    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        DFS(root, 0);
        return root;
    }


    public int DFS(TreeNode root, int preSum){
        if(root.right != null) preSum = DFS(root.right, preSum);
        root.val = root.val + preSum;
        return (root.left != null) ? DFS(root.left, root.val) : root.val;
    }


    public static void main(String[] args) {


    }













}