package leetcode;

/**
 * @author: nj
 * @date: 2020-01-05 16:04
 * @version: 0.0.1
 */
public class Code_110_Tree {


    /**
     *Given a binary tree, determine if it is height-balanced.
     *
     * For this problem, a height-balanced binary tree is defined as:
     *
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     *
     *
     *
     * Example 1:
     *
     * Given the following tree [3,9,20,null,null,15,7]:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * Return true.
     *
     * Example 2:
     *
     * Given the following tree [1,2,2,3,3,null,null,4,4]:
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * Return false.
     *
     *
     * tree depth
     *
     */
    public static boolean isBalance = true;
    public static boolean isBalanced(TreeNode root) {
        height(root);
        return isBalance;
    }

    static int height(TreeNode root){
        //递归出口
        if(root == null || !isBalance){
            return 0;
        }
        System.out.println("value:"+root.val);
        int leftLen = getHeight(root.left);
        int rightLen = getHeight(root.right);
        System.out.println("leftLen:"+leftLen+"rightLen:"+rightLen);

        if(Math.abs(leftLen - rightLen) > 1){
            isBalance = false;
        }
        return 1 + Math.max(leftLen,rightLen);
    }

    static int getHeight(TreeNode root){
        //递归出口
        if(root == null){
            return 0;
        }
        int leftLen = getHeight(root.left);
        int rightLen = getHeight(root.right);
        return 1 + Math.max(leftLen,rightLen);
    }

    public static boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;
        return checkBalance(root) && isBalanced(root.left) && isBalanced(root.right);
    }
    private static boolean checkBalance(TreeNode node) {
        System.out.println("value:"+node.val);
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        System.out.println("leftLen:"+leftDepth+"--rightLen:"+rightDepth);
        return Math.abs(leftDepth-rightDepth) <= 1;
    }
    private static int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);

        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;


        //求最大高度
        System.out.println("maxDepth:"+getHeight(treeNode1));

//        System.out.println("isBalance:" + isBalanced(treeNode1));
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t3.left = t4;
        t3.right = t5;
        t1.left = t2;
        t1.right = t3;
//        System.out.println("isBalance:"+isBalanced(t1));

        /**
         * [1,2,2,3,null,null,3,4,null,null,4]
         *
         *               1
         *              / \
         *             2   2
         *            /    \
         *           3      3
         *          /       \
         *         4        4
         */
        TreeNode tt1 = new TreeNode(1);
        TreeNode tt2 = new TreeNode(2);
        TreeNode tt3 = new TreeNode(2);
        TreeNode tt4 = new TreeNode(3);
        TreeNode tt5 = new TreeNode(3);
        TreeNode tt6 = new TreeNode(4);
        TreeNode tt7 = new TreeNode(4);

        tt4.left = tt6;
        tt2.left = tt4;
        tt3.right = tt5;
        tt1.left = tt2;
        tt1.right = tt3;
        tt5.right = tt7;

        System.out.println("isBalance:" + isBalanced(t1));
        System.out.println("isBalance:" + isBalanced1(tt1));







    }




}