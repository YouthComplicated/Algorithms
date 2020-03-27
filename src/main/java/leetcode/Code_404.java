package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 16:18
 * @version: 0.0.1
 */
public class Code_404 {

    /**
     * Find the sum of all left leaves in a given binary tree.
     *
     * Example:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *  32+22= 54;
     *
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     *
     *
     * 标准：什么是左子树的叶子节点
     *
     * 【 parent -> parent.left(叶子节点)】
     *
     * 算出所有的叶子节点和
     *
     * 算出所有的右字树节点的和
     *
     * 所有节点的和
     *
     */

    /**
     * 所有节点的和
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root != null){
            res += root.val;
        }
        if(root.left != null){
            res += sumOfLeftLeaves(root.left);
        }
        if(root.right != null){
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

    /**
     * 所有叶子节点的值
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves1(TreeNode root) {
        int res = 0;
        if(root != null && root.left == null && root.right == null){
            System.out.println("root:"+root.val);
            res += root.val;
        }
        if(root.left != null){
            res += sumOfLeftLeaves1(root.left);
        }
        if(root.right != null){
            res += sumOfLeftLeaves1(root.right);
        }
        return res;
    }

    /**
     * 左子树的叶子节点
     *
     * 【 parent -> parent.left(叶子节点)】
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves2(TreeNode root) {
        return findLeftNode(root, null);
    }


    public static int findLeftNode(TreeNode root, TreeNode parent){
        int res = 0;
        if(root == null){
            return res;
        }
        if(root.left == null && root.right == null && parent.left == root){
            res += root.val;
        }
        res += findLeftNode(root.left, root)+ findLeftNode(root.right,root);
        return res;

    }





    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.right = treeNode3;


//        System.out.println(sumOfLeftLeaves(treeNode1));
//        System.out.println(sumOfLeftLeaves1(treeNode1));
        System.out.println(sumOfLeftLeaves2(treeNode1));

    }
}