package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_104 {

    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its depth = 3.
     */


    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.add(root);
        int len = 1;
        while(true){
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    tempQueue.add(temp.left);
                }
                if(temp.right != null){
                    tempQueue.add(temp.right);
                }
            }
            if(tempQueue.isEmpty()){
                break;
            }
            queue = tempQueue;
            len++;
        }
        return len;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        MaximumDepthOfBinaryTree_104 a = new MaximumDepthOfBinaryTree_104();
        System.out.println(a.maxDepth(treeNode1));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
