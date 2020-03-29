package leetcode;


import base.List.LinkListQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: nj
 * @date: 2020-03-26 21:16
 * @version: 0.0.1
 */
public class Code_437 {

    /**
     * You are given a binary tree in which each node contains an integer value.
     *
     * Find the number of paths that sum to a given value.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from
     * parent nodes to child nodes).
     *
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     *
     * Example:
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Return 3. The paths that sum to 8 are:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     */


    public static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return  0;
        }
        int res = 0, tempSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res += pathSumT(node, sum, tempSum);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    /**
     *
     * @param root
     * @param sum
     * @param tempSum
     * @return
     */
    public static int pathSumT(TreeNode root, int sum, int tempSum){
        int result = 0;
        tempSum += root.val;
        if(tempSum == sum){
            result += 1;
            /**
             * 此处不能return 因为 必需贪心判断sum的值
             */
//            return 1;
        }
        if(root.left != null){
            result += pathSumT(root.left, sum, tempSum);
        }
        if(root.right != null){
            result += pathSumT(root.right, sum, tempSum);
        }
        return result;
    }

    /**
     *
     * Typical recursive DFS.
     * Space: O(n) due to recursion.
     * Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
     *
     *
     * 编码十分干净
     *
     */
    public int pathSum11(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum11(root.left, sum) + pathSum11(root.right, sum);
    }
    /**
     *             10
     *            /  \
     *           5   -3
     *          / \    \
     *         3   2   11
     *        / \   \
     *       3  -2   1
     */
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }


    public int pathSum111(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        //Default sum = 0 has one count
        map.put(0, 1);
        return backtrack(root, 0, sum, map);
    }


    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        sum += root.val;
        //See if there is a subarray sum equals to target
        int res = map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0)+1);

        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        //Remove the current node so it wont affect other path
        map.put(sum, map.get(sum)-1);
        return res;
    }



    public static void main(String[] args) {
        /**
         *      *       10
         *      *      /  \
         *      *     5   -3
         *      *    / \    \
         *      *   3   2   11
         *      *  / \   \
         *      * 3  -2   1
         */
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node4.left = node7;
        node4.right = node8;

        node5.right = node9;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node1.left = node2;
        node1.right = node3;


//        System.out.println(pathSumT(node2, 8, 0));

        System.out.println(pathSum(node1, 8));

        /**
         *    -2
         *      \
         *       -3
         */
        TreeNode a1 = new TreeNode(-2);
        TreeNode a2 = new TreeNode(-3);
        a1.right = a2;
        System.out.println(pathSum(a1, -5));

        /**
         *                  1
         *                 /  \
         *                -2   -3
         *               /  \    \
         *              1   3    -1
         */


    }


}