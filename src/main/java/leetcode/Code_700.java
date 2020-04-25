package leetcode;

/**
 * @author: nj
 * @date: 2020-04-19 20:34
 * @version: 0.0.1
 */
public class Code_700 {


    /**
     * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that
     * the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
     *
     * For example,
     *
     * Given the tree:
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     *
     * And the value to search: 2
     * You should return this subtree:
     *
     *       2
     *      / \
     *     1   3
     * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
     *
     * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [],
     * not null.
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return  null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if(left != null){
            return left;
        }
        TreeNode right = searchBST(root.right, val);
        if(right != null){
            return  right;
        }
        return null;
    }


    TreeNode found = null;

    public TreeNode searchBST1(TreeNode root, int val) {
        inOrder(root, val);
        return found;
    }

    public void inOrder(TreeNode node, int val) {
        if (node.val == val) {
            found = node;
            return;
        }
        if (node.left != null) {
            inOrder(node.left, val);
        }
        if (node.right != null) {
            inOrder(node.right, val);
        }
    }




}