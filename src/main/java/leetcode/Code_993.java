package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nj
 * @date: 2020-05-06 16:24
 * @version: 0.0.1
 */
public class Code_993 {


    /**
     *
     * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     *
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     *
     * We are given the root of a binary tree with unique values, and the values x and y of two different
     * nodes in the tree.
     *
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     *
     * Example 1:
     *
     * Input: root = [1,2,3,4], x = 4, y = 3
     * Output: false
     * Example 2:
     *
     * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
     * Output: true
     * Example 3:
     *
     * Input: root = [1,2,3,null,4], x = 2, y = 3
     * Output: false
     *
     * Note:
     *
     * The number of nodes in the tree will be between 2 and 100.
     * Each node has a unique integer value from 1 to 100.
     *
     *
     *
     * 1、如何记录深度
     *
     * 2、节点的父亲不相等
     *
     *
     */

    private int xDepth, yDepth;
    private TreeNode xParent;
    private TreeNode yParent;

    public static boolean isCousins(TreeNode root, int x, int y) {

        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isFindX , isFindY;
//        while (queue.size() > 0){
        while (!queue.isEmpty()){
            int size =  queue.size();
            isFindX = isFindY = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                if(node.val == x){
                    isFindX = true;
                }else if(node.val == y){
                    isFindY = true;
                }
                if(node.left != null  && node.right != null){
                    if((node.left.val == x || node.left.val == y)
                        && (node.right.val == x || node.right.val == y)){
                        return false;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }else if(node.right != null){
                    queue.add(node.right);
                }else if(root.left != null){
                    queue.add(node.left);
                }
            }

            if(isFindX && isFindY){
                return true;
            }else if(isFindX || isFindY){
                return false;
            }

        }
        return false;

    }


    public boolean findDepth(TreeNode parentNode, TreeNode root, int x, int xDepth){

        if(root == null){
            return false;
        }
        if(root.val == x){
            return true;
        }
        return findDepth(root, root.left, x, xDepth + 1)
                || findDepth(root, root.right, x, xDepth + 1);
    }


    public boolean isCousins1(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent? true: false;
    }
    //get both the depth and parent for x and y
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }

        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        } else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        } else {
            getDepthAndParent(root.left, x, y, depth + 1, root);
            getDepthAndParent(root.right, x, y, depth + 1, root);
        }

    }





    public static void main(String[] args) {


        TreeNode binTree = TreeNodeUtils.createBinTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(isCousins(binTree, 4,6));

        TreeNode binTree1 = TreeNodeUtils.createBinTree(Arrays.asList(1, 2, 3, 4));
        System.out.println(isCousins(binTree1, 4,3));
    }

}