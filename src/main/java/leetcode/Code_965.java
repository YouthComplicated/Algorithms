package leetcode;

/**
 * @author: nj
 * @date: 2020-05-04 17:24
 * @version: 0.0.1
 */
public class Code_965 {

    /**
     * A binary tree is univalued if every node in the tree has the same value.
     *
     * Return true if and only if the given tree is univalued.
     *
     * Example 1:
     *
     * Input: [1,1,1,1,1,null,1]
     * Output: true
     * Example 2:
     *
     *
     * Input: [2,2,2,5,2]
     * Output: false
     *
     * Note:
     *
     * The number of nodes in the given tree will be in the range [1, 100].
     * Each node's value will be an integer in the range [0, 99].
     *
     */

    public boolean isUnivalTree(TreeNode root) {

        if(root == null){
            return false;
        }
        return inOrder(root, root.val);

    }


    public boolean inOrder(TreeNode root, int val){
        if(root == null){
            return true;
        }
        if(root.val != val){
            return false;
        }
        return  inOrder(root.left, val) && inOrder(root.right, val);
    }

    public boolean isUnivalTree1(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree1(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree1(root.right)));
        return left_correct && right_correct;
    }


    public static void main(String[] args) {


    }

}