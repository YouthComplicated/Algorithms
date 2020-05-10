package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-05-10 15:15
 * @version: 0.0.1
 */
public class Code_1022 {

    /**
     *
     * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with
     * the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary,
     * which is 13.
     *
     * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
     *
     * Return the sum of these numbers.
     *
     * Example 1:
     *
     * Input: [1,0,1,0,1,0,1]
     * Output: 22
     * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     *
     *
     * Note:
     *
     * The number of nodes in the tree is between 1 and 1000.
     * node.val is 0 or 1.
     * The answer will not exceed 2^31 - 1.
     *
     *
     *
     * 1、递归的要素 出口入口 程序的执行过程
     *
     *
     *
     */



    public  int sumRootToLeaf(TreeNode root) {
        printRootToLeaf(root,0);
        return 0;
    }

    public Integer sum = 0;
    public  int printRootToLeaf(TreeNode node, int s){
        if(node == null){
            return 0;
        }
        s =  (s << 1) + node.val;
        return node.left == node.right ? s : printRootToLeaf(node.left, s) +  printRootToLeaf(node.right,s);
    }

    public int sumRootToLeaf1(TreeNode root) {
        return dfs1(root, 0);
    }

    public int dfs1(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return root.left == root.right ? val : dfs1(root.left, val) + dfs1(root.right, val);
    }


    public static void main(String[] args) {


        TreeNode binTree = TreeNodeUtils.createBinTree(Arrays.asList(1, 0, 1, 0, 1, 0, 1));
        Integer sum = 0;

        Code_1022 code_1022 =  new Code_1022();
        System.out.println(code_1022.printRootToLeaf(binTree,0));
        System.out.println(sum);


    }



}