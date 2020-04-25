package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-18 16:38
 * @version: 0.0.1
 */
public class Code_637 {


    /**
     *
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     * Example 1:
     * Input:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * Output: [3, 14.5, 11]
     * Explanation:
     * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     * Note:
     * The range of node's value is in the range of 32-bit signed integer.
     *
     *
     * 层序遍历 思路: 借助queue
     *
     */

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return Collections.EMPTY_LIST;
        }
        queue.add(root);
        List<Double> result = new ArrayList<>();
        Double sum; int size;
        while (!queue.isEmpty()){
            size = queue.size();
            sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;

    }


    /**
     * 递归遍历
     *
     *
     * 实用前序遍历 基于高度层级，标识每层的sum和节点数
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        int height = getHeight(root);
        long[] sum = new long[height];
        int[] count = new int[height];
        averageOfLevelsHelper(root, sum, count, 0);
        for (int i = 0; i < height; i++) {
            res.add((double)sum[i] / count[i]);
        }
        return res;
    }


    private void averageOfLevelsHelper(TreeNode root, long[] sum, int[] count, int level) {
        if (root == null) {
            return;
        }
        sum[level] += root.val;
        count[level]++;
        averageOfLevelsHelper(root.left, sum, count, level + 1);
        averageOfLevelsHelper(root.right, sum, count, level + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }






    public static void main(String[] args) {
        /**
         * Input:
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * Output: [3, 14.5, 11]
         */
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;


        System.out.println(averageOfLevels(treeNode1));
        System.out.println(averageOfLevels(null));

    }


}