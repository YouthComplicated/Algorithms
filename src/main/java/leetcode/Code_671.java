package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-18 20:35
 * @version: 0.0.1
 */
public class Code_671 {

    /**
     * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node
     * in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is
     * the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val)
     * always holds.
     *
     * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in
     * the whole tree.
     *
     * If no such second minimum value exists, output -1 instead.
     *
     * Example 1:
     *
     * Input:
     *     2
     *    / \
     *   2   5
     *      / \
     *     5   7
     *
     * Output: 5
     * Explanation: The smallest value is 2, the second smallest value is 5.
     *
     *
     * Example 2:
     *
     * Input:
     *     2
     *    / \
     *   2   2
     *
     * Output: -1
     * Explanation: The smallest value is 2, but there isn't any second smallest value.
     *
     *
     *
     * 1、第一种思路，遍历所有节点，找出第二大的数据
     *
     * 2、
     *
     */

    static int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    static boolean hasSecondMax = false;
    public static int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        inOrder(root);
        return !hasSecondMax && min2 == Integer.MAX_VALUE ? -1 : min2;
    }

    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        if(min1 > node.val){
            min2 = min1;
            min1 = node.val;
        }else if(min1 == node.val){
            //do nothing
        }else if(min2 == node.val){
            //have Max
            hasSecondMax = true;
        }else if(min2 > node.val){
            min2 = node.val;
        }
        inOrder(node.left);
        inOrder(node.right);
    }



    public int findSecondMinimumValue1(TreeNode root) {
        Set<Integer> uniques = new HashSet<>();
        dfs(root, uniques);
        int min1 = root.val;

        //找出第二小数据，这里使用long，如果使用Integer.MAX_VALUE，必需判断是否含有该节点
        long ans = Long.MAX_VALUE;

        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }


    /**
     * Let text{min1 = root.val}min1 = root.val. When traversing the tree at some node, text{node}node,
     * if text{node.val > min1}node.val > min1, we know all values in the subtree at \text{node}node are at least
     * \text{node.val}node.val, so there cannot be a better candidate for the second minimum in this subtree. Thus,
     * we do not need to search this subtree.
     */
    int min11;
    long ans = Long.MAX_VALUE;
    public void dfs(TreeNode root) {
        if (root != null) {
            if (min11 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min11 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue2(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }

    /**
     *  root root.left root.right
     */
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }


    public int findSecondMinimumValue3(TreeNode root) {
        if(root==null)  return -1;
        return findSecondMinValue(root, root.val);
    }


    public int findSecondMinValue(TreeNode root, int min) {
        if(root==null)  return -1;
        if(root.val>min)   return root.val;
        int leftMin = findSecondMinValue(root.left,min);
        int rightMin = findSecondMinValue(root.right,min);
        return (leftMin==-1 || rightMin==-1) ? Math.max(leftMin,rightMin) : Math.min(leftMin,rightMin);
    }


    public static void main(String[] args) {
        /**
         * Input:
         *     2
         *    / \
         *   2   5
         *      / \
         *     5   7
         */
        TreeNode binTree = TreeNodeUtils.createBinTree(Arrays.asList(2,2,5,null,null,5,7));
//        TreeNodeUtils.levelOrder(binTree);

//        System.out.println(findSecondMinimumValue(binTree));
        /**
         * Example 2:
         *
         * Input:
         *     2
         *    / \
         *   2   2
         */

        TreeNode binTree1 = TreeNodeUtils.createBinTree(Arrays.asList(2, 2, 2));
        System.out.println(findSecondMinimumValue(binTree1));


    }










}