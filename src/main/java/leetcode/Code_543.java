package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author: nj
 * @date: 2020-04-12 09:24
 * @version: 0.0.1
 */
public class Code_543 {


    /**
     *
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
     * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \  / \
     *       4   5 8  9
     *      / \
     *     6   7
     *
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.
     *
     *
     *
     * 求左子树的最大深度和右子树的最大深度 这种思路错误
     *
     * 每个节点的之间的距离
     *
     * 四种访问方式
     * 1、前序  根左右   [1,2,4,6,7,5,3]
     * 2、中序  左根右   [6,4,7,2,5,1,3]   中序符合计算node节点的距离
     * 3、后序  左右根   [6,7,4,5,2,3,1]
     * 4、层序
     *
     *
     *
     * 二叉树的递归遍历,富于变化操作.
     *
     */

    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

//    /**
//     * 寻找Max
//     */
//    public static int inOrderMax(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        max = Math.max(max,inOrderMax(root.left) + 1);
////        System.out.print(root.val+",");
//        System.out.println("max:" + max);
//        max = Math.max(max,inOrderMax(root.right) + 1);
//        return max;
//    }


    public int diameterOfBinaryTree1(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        System.out.println("max:"+max+ " left:" + left + " right:" + right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {

        /**
         *           1
         *          /  \
         *         2    3
         *        / \  / \
         *       4   5 8  9
         *      / \
         *     6   7
         */
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a31 = new TreeNode(8);
        TreeNode a32 = new TreeNode(9);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);

        a4.left = a6;
        a4.right = a7;
        a2.left = a4;
        a2.right = a5;
        a1.left = a2;
        a1.right = a3;
        a3.left = a31;
        a3.right = a32;


        System.out.println(diameterOfBinaryTree(a1));

        System.out.println("前序遍历:");
        preOrder(a1);
        System.out.println();
        System.out.println("中序遍历:");
        inOrder(a1);
        System.out.println();
        System.out.println("后序遍历:");
        postOrder(a1);
        System.out.println();
        System.out.println("层序遍历:");
        levelOrder(a1);



        //create tree
//        int [] arr = {1,2,3,4,5,8,9,6,7};
//        createBinTree(arr);
//        System.out.println();
//        TreeNode temp = nodeList.get(0);
//        System.out.println("前序遍历:");
//        preOrder(temp);
//        System.out.println();
//        System.out.println("中序遍历:");
//        inOrder(temp);
//        System.out.println();
//        System.out.println("后序遍历:");
//        postOrder(temp);
//        System.out.println();
//        System.out.println("层序遍历:");
//        levelOrder(temp);










    }

    /**
     * 中序 [6,4,7,2,5,1,3]
     */
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+",");
        inOrder(root.right);
    }

    /**
     * 前序 [1,2,4,6,7,5,3]
     */
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+",");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 后序 [6,7,4,5,2,3,1]
     */
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+",");
    }

    /**
     *
     * 层序遍历
     *
     */
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+",");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    /**
     *
     * 树的构造
     *
     */
    static List<TreeNode> nodeList = null;
    public static void createBinTree(int[] arr) {
        nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < arr.length; nodeIndex++) {
            nodeList.add(new TreeNode(arr[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = arr.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (arr.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }





}