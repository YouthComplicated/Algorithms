package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-19 11:12
 * @version: 0.0.1
 */
public class Code_669 {

    /**
     *
     * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its
     * elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return
     * the new root of the trimmed binary search tree.
     *
     * Example 1:
     * Input:
     *     1
     *    / \
     *   0   2
     *
     *   L = 1
     *   R = 2
     *
     * Output:
     *     1
     *       \
     *        2
     * Example 2:
     * Input:
     *     3
     *    / \
     *   0   4
     *    \
     *     2
     *    /
     *   1
     *
     *   L = 1
     *   R = 3
     *
     * Output:
     *       3
     *      /
     *    2
     *   /
     *  1
     *
     *  排序的遍历： 从小到大 L-R
     */
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        dfs(null, root, L, R);
        return root;
    }

    static TreeNode treeNode;
    public static  void dfs(TreeNode parent, TreeNode root, int L, int R){
        if(root == null){
            return;
        }

        if(root.val < L){
            if(parent != null){
                parent.left = root.right;
                TreeNode pNode = new TreeNode(parent.val);
                pNode.left = new TreeNode(root.right.val);
            }else{
                treeNode = root.right;
            }
        }else if(root.val > R){
            if(parent != null) {
                parent.right = null;
            }
        }

        dfs(root, root.left, L, R);
        dfs(root, root.right, L, R);
    }

    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST1(root.right, L, R);
        if (root.val > R) return trimBST1(root.left, L, R);

        root.left = trimBST1(root.left, L, R);
        root.right = trimBST1(root.right, L, R);

        return root;
    }


    public static void main(String[] args) {
        /**
         * Example 1:
         * Input:
         *     1
         *    / \
         *   0   2
         *
         *   L = 1
         *   R = 2
         *
         * Output:
         *     1
         *       \
         *        2
         */
        TreeNode binTree = TreeNodeUtils.createBinTree(Arrays.asList(1, 0, 2));
        TreeNode treeNode = trimBST(binTree, 1, 2);
        System.out.println();

        /**
         * Input:
         *     3
         *    / \
         *   0   4
         *    \
         *     2
         *    /
         *   1
         *
         *   L = 1
         *   R = 3
         *
         * Output:
         *       3
         *      /
         *    2
         *   /
         *  1
         *
         *  1
         *   \
         *    2
         */
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(0);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.right = a4;
        a4.left = a5;
        TreeNode treeNode1 = trimBST(a1, 1, 3);
        System.out.println();

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        b1.right = b2;
        TreeNode treeNode2 = trimBST(b1, 2, 3);
        TreeNodeUtils.levelOrder(treeNode2);
        System.out.println();
    }


}