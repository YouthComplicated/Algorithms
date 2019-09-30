package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_112 {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
     * along the path equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     *
     *
     *
     * 前序 中序  后序 层序
     *
     * 前序:根左右  5-》4-》11-》7-》2-》8-》13-》4-》1
     *
     * 中序:左根右  7-》11-》2-》4-》5-》13-》8-》4-》1
     *
     * 后序:左右根  7-》2-》11-》4-》13-》1-》4-》8-》5
     *
     *
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        DLSum(root,22,list);
        return !list.isEmpty();
    }


    public static void DLSum(TreeNode root, int sum, List<Integer> list) {
        if(root == null){
            return;
        }
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0 ){
                list.add(sum);
            }
        }
        if (root.left != null) {
             DLSum(root.left, sum,list);
        }
        if(root.right != null){
            DLSum(root.right,sum,list);
        }

    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);

    }

    public boolean dfs(TreeNode root, int leftSum) {
        if (root == null && leftSum != 0){
            return false;
        }else if(root != null && root.left == null && root.right==null && leftSum == root.val) {
            return true;
        }

        if (root != null){
            return dfs(root.left, leftSum - root.val) || hasPathSum(root.right, leftSum - root.val);
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        if(root != null && root.left == null && root.right==null) {
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(11);
        TreeNode node8 = new TreeNode(4);
        node3.left = node1;
        node3.right = node2;
        node8.left = node3;

        TreeNode node9 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(8);
        node4.right = node9;
        node7.left = node6;
        node7.right = node4;

        TreeNode node5 = new TreeNode(5);
        node5.left = node8;
        node5.right = node7;



//        DLR(node5);
//        System.out.println();
//        LDR(node5);
//        System.out.println();
//        LRD(node5);
//        System.out.println();

        DLRSum(node5,0);
        System.out.println("========");
        System.out.println(hasPathSum(node5,22));
    }

    public static void DLRSum(TreeNode node, int sum){
//        System.out.print(node.val+",");
        sum += node.val;
        if (node.left != null) {
            DLRSum(node.left,sum);
        }
        if(node.right != null){
            DLRSum(node.right,sum);
        }
        if(node.left == null && node.right == null){
            System.out.println(sum+"--"+node.val);
        }

    }

    //前序:根左右  5-》4-》11-》7-》2-》8-》13-》4-》1
    public static void DLR(TreeNode node){
        System.out.print(node.val+",");
        if (node.left != null) {
            DLR(node.left);
        }
        if(node.right != null){
            DLR(node.right);
        }
    }
    //中序: 左根右 7-》11-》2-》4-》5-》13-》8-》1-》4
    public static void LDR(TreeNode node){
        if (node.left != null) {
            LDR(node.left);
        }
        System.out.print(node.val+",");
        if(node.right != null){
            LDR(node.right);
        }
    }

    //后序: 左右根7-》2-》11-》4-》13-》1-》4-》8-》5
    public static void LRD(TreeNode node){
        if (node.left != null) {
            LRD(node.left);
        }
        if(node.right != null){
            LRD(node.right);
        }
        System.out.print(node.val+",");
    }


    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}
