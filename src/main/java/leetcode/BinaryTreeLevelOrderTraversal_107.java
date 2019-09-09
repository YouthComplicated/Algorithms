package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BinaryTreeLevelOrderTraversal_107 {


    /**
     *Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its bottom-up level order traversal as:
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> linkedList = new LinkedList<>();
        if(root == null){
            return null;
        }
        linkedList.add(root);
        while(true){
            List<TreeNode> list = new LinkedList<>();
            List<Integer> valueList = new ArrayList<>();
            while (!linkedList.isEmpty()){
                TreeNode temp = ((LinkedList<TreeNode>) linkedList).removeFirst();
                valueList.add(temp.val);
                if(temp.left != null){
                    list.add(temp.left);
                }
                if(temp.right != null){
                    list.add(temp.right);
                }
            }
            result.add(valueList);
            if(list.isEmpty()){
                break;
            }
            linkedList = list;
        }

        List<List<Integer>> ll = new ArrayList<>();
        ListIterator<List<Integer>> iterator = result.listIterator(result.size());
        while (iterator.hasPrevious()){
            ll.add(iterator.previous());
        }
        return ll;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        BinaryTreeLevelOrderTraversal_107 aaa = new BinaryTreeLevelOrderTraversal_107();
        System.out.println(aaa.levelOrderBottom(treeNode1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
