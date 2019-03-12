package leetcode;

/**
 * @author NJ
 * @date 2019/3/12 11:43
 */
public class SameTree_100 {
    /**
     * Given two binary trees, write a function to check if they are the same or not.

     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

     Example 1:

     Input:     1         1
        / \       / \
     2   3     2   3

     [1,2,3],   [1,2,3]

     Output: true
     Example 2:

     Input:     1         1
             /           \
             2             2

     [1,2],     [1,null,2]

     Output: false
     Example 3:

     Input:     1         1
             / \       / \
             2   1     1   2

     [1,2,1],   [1,1,2]

     Output: false
     * @param p
     * @param q
     * @return
     */

    /**
     * 递归实现
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(q.val != p.val){
                return false;
            }
            if(isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right)){
                return true;
            }else{
                return false;
            }
        }else if(p == null && q == null){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        SameTree_100 tree = new SameTree_100();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;


        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode41 = new TreeNode(5);
        treeNode11.left = treeNode21;
        treeNode11.right = treeNode31;
        treeNode31.left = treeNode41;

        System.out.println(tree.isSameTree(treeNode1,treeNode11));

        System.out.println("==================");

    }

    public static void tranfer(TreeNode treeNode){
        if(treeNode != null){
            System.out.println(treeNode.val);
            tranfer(treeNode.left);
            tranfer(treeNode.right);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
