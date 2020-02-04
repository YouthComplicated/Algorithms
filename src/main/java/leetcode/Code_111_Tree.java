package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nj
 * @date: 2020-01-05 18:05
 * @version: 0.0.1
 */
public class Code_111_Tree {

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
     * return its minimum depth = 2.
     *
     *     1
     *    /
     *   2
     *
     *  每个叶子节点的高度
     *
     *  最短路径问题
     *
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = root.left == null ? 0 : height(root.left);
        int rightDepth = root.right == null ? 0 : height(root.right);
        if(leftDepth == 0){
            return rightDepth + 1;
        }else if(rightDepth == 0){
            return leftDepth + 1;
        }else{
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

    static int height(TreeNode root){
        //递归出口
        if(root == null){
            return 0;
        }
        System.out.println("value:"+root.val);
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftLen = height(root.left);
        int rightLen = height(root.right);
        if(root.left != null && root.right != null){
            return 1 + Math.min(leftLen,rightLen);
        }else{
            return 1 + Math.max(leftLen,rightLen);
        }


    }

    public boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        if(isLeaf(root)) return 1;
        Queue<TreeNode> queue = new LinkedList();
        int level = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(isLeaf(node)) return level;
                if(node.left!= null) queue.add(node.left);
                if(node.right!= null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }


    public static void main(String[] args) {
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
        System.out.println(minDepth(t1));
    }



}