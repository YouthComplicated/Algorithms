package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-04-18 19:07
 * @version: 0.0.1
 */
public class Code_653 {

    /**
     *
     *
     *Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their
     *sum is equal to the given target.
     *
     * Example 1:
     *
     * Input:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 9
     *
     * Output: True
     *
     *
     * Example 2:
     *
     * Input:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 28
     *
     * Output: False
     *
     *
     *
     * 如果不是二叉树则问题划归为在一个数组中寻找两个数相加等于给定值
     *
     * 如何三个数相加等于给定的数
     *
     * n个数相加 == 给定的数
     *
     *
     *
     * Time Complexity: O(n), Space Complexity: O(n).
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }


    /**
     *
     * 排序 放入list中
     * Time Complexity: O(n), Space Complexity: O(n).
     *
     */
    public boolean findTarget1(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums.get(i) + nums.get(j) == k)return true;
            if(nums.get(i) + nums.get(j) < k)i++;
            else j--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     *
     * The idea is to use binary search method. For each node, we check if k - node.val exists in this BST.
     *
     * Time Complexity: O(nh), Space Complexity: O(h). h is the height of the tree, which is logn at best case,
     *
     * and n at worst case.
     */
    public boolean findTarget2(TreeNode root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }



    public static void main(String[] args) {


    }





}