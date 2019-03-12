package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author NJ
 * @date 2019/3/12 12:52
 */
public class SymmetricTree_101 {
    /**
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

            1
           / \
         2   2
        / \ / \
        3  4 4  3
     But the following [1,2,2,null,3,null,3] is not:
          1
        / \
      2   2
      \   \
      3    3
     */

    /**
     * 层序遍历  使用队列先进先出
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return  false;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        TreeNode left = root.left, right = root.right;
        leftQueue.add(left);
        rightQueue.add(right);
        int n,m;
        while(!leftQueue.isEmpty()){
            n = leftQueue.size();
            m = rightQueue.size();
            if(n != m){
                return false;
            }
            for(int i = 0; i < n; i++){
                left = leftQueue.poll();
                right = rightQueue.poll();
                if(left != null && right != null){
                    if(left.val != right.val){
                        return false;
                    }
                }else if(right == null && left == null){
                    continue;
                }else{
                    return false;
                }
                leftQueue.add(left.left);
                leftQueue.add(left.right);
                rightQueue.add(right.right);
                rightQueue.add(right.left);
            }
        }
        return true;
    }

    /**
     * 只用了一个队列，关键点在于放入的顺序
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    //[9,-42,-42,null,76,76,null,null,13,null,13]
    public static void main(String[] args) {
        SymmetricTree_101 s = new SymmetricTree_101();


        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);

        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode7;
        treeNode3.right = treeNode6;


        System.out.println(s.isSymmetric(treeNode1));

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
