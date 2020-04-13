package leetcode;

/**
 * @author: nj
 * @date: 2020-04-11 10:14
 * @version: 0.0.1
 */
public class Code_530 {


    /**
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * Output:
     * 1
     *
     * Explanation:
     * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
     *
     *
     * Note:
     *
     * There are at least two nodes in this BST.
     * This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
     *
     *
     * 注意不是相邻节点进行处理，是任意节点的差值最小
     *
     *
     * getMinimumDifference() 计算的是相邻节点的差值
     *
     */
    public static int min = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if(root == null){
            return min;
        }
        if(root.left != null){
//            System.out.println("a.left:"+root.left.val);
            min = Math.min(min,root.val - root.left.val);
        }
        getMinimumDifference(root.left);

        if(root.right != null){
//            System.out.println("a.right:"+root.right.val);
            min = Math.min(min, root.right.val - root.val);
        }
        getMinimumDifference(root.right);

//        minMum(root);
        return min;

    }



    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prev;
    public  void minMum(TreeNode a){
        if(a == null){
            return;
        }
        minMum(a.left);
        if (prev != null) minDiff = Math.min(minDiff, a.val - prev.val);
        prev = a;
        minMum(a.right);
    }




    public static int getMinimumDifference1(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    /**
     * 有序遍历节点，先左子树，后右子树
     * @param root
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
//            System.out.println("prevAAAA:" + (prev == null ? "null" : prev.val));
            return;
        }
        System.out.println("root:"+root.val);
        inorder(root.left);

        if (prev != null){
            minDiff = Math.min(minDiff, root.val - prev.val);
            System.out.println("++++:"+root.val+":"+prev.val);
        }
        prev = root;
        System.out.println("prev:" + (prev == null ? "null" : prev.val));
        inorder(root.right);
    }


    /**
     * 此种遍历没有顺序(对于BST来说)
     * @param root
     * @return
     */
    public static int minDiffInBST(TreeNode root) {
        if(root == null){
            return min;
        }
        if(root.left != null){
            System.out.println("root.val:" + root.val + "root.left.val" + root.left.val);
            min = Math.min(min,root.val - root.left.val);
        }
        if(root.right != null){
            System.out.println("root.val:" + root.val + "root.right.val" + root.right.val);
            min = Math.min(min, root.right.val - root.val);
        }
        minDiffInBST(root.left);
        minDiffInBST(root.right);
        return min;

    }





    public static void main(String[] args) {

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        node2.left = node3;
//        node1.right = node2;
//        System.out.println(getMinimumDifference1(node1));

        System.out.println("=======================");

//        TreeNode a1 = new TreeNode(236);
//        TreeNode a2 = new TreeNode(104);
//        TreeNode a3 = new TreeNode(701);
//        TreeNode a4 = new TreeNode(227);
//        TreeNode a41 = new TreeNode(100);
//        TreeNode a42 = new TreeNode(99);
//        TreeNode a5 = new TreeNode(911);
//        a2.right = a4;
//        a4.left = a41;
//        a1.left = a2;
//        a3.right = a5;
//        a1.right = a3;
//        a41.left = a42;
//        System.out.println(getMinimumDifference1(a1));



        TreeNode a1 = new TreeNode(27);
        TreeNode a2 = new TreeNode(34);
        TreeNode a3 = new TreeNode(58);
        TreeNode a4 = new TreeNode(50);
        TreeNode a5 = new TreeNode(44);
        a4.left = a5;
        a3.left = a4;
        a2.right = a3;
        a1.right = a2;
        System.out.println(minDiffInBST(a1));



    }








}