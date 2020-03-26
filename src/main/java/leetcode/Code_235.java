package leetcode;

/**
 * @author: nj
 * @date: 2020-03-20 10:12
 * @version: 0.0.1
 */
public class Code_235 {

    /**
     *
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
     *
     * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *
     *
     * Example 1:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     *
     *
     * Note:
     *
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the BST.
     *
     *
     */


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if(root == p || root == q){
            if(leftNode == p || leftNode == q || rightNode == p || rightNode == q){
                return root;
            }else if(leftNode != null){
                if(leftNode.left == p || leftNode.left == q || leftNode.right == p || leftNode.right == q){
                    return root;
                }else{
                    return null;
                }
            }else if(rightNode != null){
               if(rightNode.left == p || rightNode.left == q || rightNode.right == p || rightNode.right == q){
                   return  root;
               }else {
                   return null;
               }
            }else {
                return null;
            }
        }else {
            if((leftNode == p && rightNode == q)
                || (leftNode == q && rightNode == p)){
                return root;
            }else{
                if(leftNode != null){
                    return lowestCommonAncestor(leftNode, p, q);
                }if(rightNode != null){
                    return lowestCommonAncestor(rightNode, p, q);
                }else{
                    return null;
                }
            }
        }
    }


    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return getParentNode(null, root, p,q);
    }


    public static  TreeNode getParentNode(TreeNode parent, TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if(root == p){
            if(leftNode != null && (leftNode.left == q || leftNode.right == q)){
                return leftNode;
            }else{
                //该分支是否含有另外节点，如果有返回root, 没有返回root的parent
                boolean b = hasNode1(root, q);
                return hasNode1(root, q) ? root : (parent == null ? leftNode : parent);
            }
        }else if(root == q){
            if(rightNode != null && (rightNode.left == p || rightNode.right == p)){
                return rightNode;
            }else{
                //该分支是否含有另外节点,如果有返回root, 没有返回root的parent
                boolean b = hasNode1(root, p);
                return hasNode1(root, p) ? root : (parent == null ? rightNode : parent);
            }
        }else{
            if(leftNode != null){
                return getParentNode(root, leftNode, p, q);
            }else if(rightNode != null){
                return getParentNode(root, rightNode, p, q);
            }else {
                return null;
            }
        }

    }


    public static boolean hasNode(TreeNode root, TreeNode p){
        if(root == p){
            return true;
        }else if(root.left != null){
            hasNode(root.left, p);
        }else if(root.right != null){
            hasNode(root.right, p);
        }
        return false;
    }

    /**
     * 如果不是二叉树，无法进行递归查找
     * @param root
     * @param p
     * @return
     */
    public static boolean hasNode1(TreeNode root, TreeNode p){
        if(root == p){
            return true;
        }
        if(root.left != null){
            hasNode1(root.left, p);
        }
        if(root.right != null){
            hasNode1(root.right, p);
        }
        return false;
    }




    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(5);

        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

//        TreeNode treeNode = lowestCommonAncestor1(treeNode1, treeNode2, treeNode3);
//        TreeNode treeNode111 = lowestCommonAncestor1(treeNode1, treeNode2, treeNode5);
//        TreeNode treeNode1111 = lowestCommonAncestor1(treeNode1, treeNode1, treeNode5);

        hasNode1(treeNode2, treeNode5);

        System.out.println(1111);
    }

}