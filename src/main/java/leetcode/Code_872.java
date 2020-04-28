package leetcode;

import base.Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-04-28 19:48
 * @version: 0.0.1
 */
public class Code_872 {


    /**
     * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
     *
     *
     *
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
     *
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     *
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     *
     *
     *
     * Constraints:
     *
     * Both of the given trees will have between 1 and 200 nodes.
     * Both of the given trees will have values between 0 and 200
     *
     *
     * 如何查找二叉树的叶子节点  node.left = null && node.right = null;
     *
     *
     * list api equals
     *
     * 简单的比较两个list值  equals
     *
     */



    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

//        if(root1 == null || root2 == null){
//            return false;
//        }

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        findLeaf(root1,res1);
        findLeaf(root2,res2);
        if(res1.size() != res2.size()){
            return false;
        }
        for (int i = 0; i < res1.size(); i++) {
            if(res1.get(i) != res2.get(i)){
                return false;
            }
        }

        return true;


    }


    public static  void findLeaf(TreeNode node, List<Integer> list){

       if(node.left == null && node.right == null){
           list.add(node.val);
       }
       if(node.left != null){
           findLeaf(node.left, list);
       }

       if(node.right != null){
           findLeaf(node.right, list);
       }
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
        System.out.println(leafSimilar(binTree, null));

        TreeNode binTree1 = TreeNodeUtils.createBinTree(Arrays.asList(1,2,null,3,null));
        System.out.println(leafSimilar(binTree1, null));

    }
}