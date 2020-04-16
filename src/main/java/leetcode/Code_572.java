package leetcode;

/**
 * @author: nj
 * @date: 2020-04-15 11:08
 * @version: 0.0.1
 */
public class Code_572 {

    /**
     *
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
     * a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
     * also be considered as a subtree of itself.
     *
     * Example 1:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.
     * Example 2:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     *
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return false.
     *
     * 1、不能通过遍历节点获取顺序来比较
     *
     * 2、递归的出口
     *
     *  s == null t != null false;
     *  s != null t == null true;
     *  s == null t == null true;
     *  s != null t != null true;  没有完成比对
     *
     *
     *  以下方法不能保证如下情况
     *
     *    1
     *     \
     *      1
     *
     *    1
     *
     */

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null && s == null){
            return true;
        }
        if(t == null || s == null){
            return false;
        }
        if(s.val != t.val){
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else{
            return isSubtree(s.right,t.right) && isSubtree(s.left,t.left);
        }
    }

    /**
     * 以下是使用了递归嵌套？？ 什么情况下使用递归嵌套
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree1(s.left, t) || isSubtree1(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        //直接返回
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    public boolean isSubtree2(TreeNode s, TreeNode t) {

        if(t==null && s==null) return true;
        if(t==null || s==null) return false;

        if(s.val == t.val)
            // Check if s.val is same as t.val.
            // Also check if both tree's left and right child are same same or not.
            // If above condition is satisfied then recursively check for all childrens of s and t.
            if( !(s.left != null && t.left != null && s.left.val != t.left.val) &&
                    !(s.right!=null && t.right!=null && s.right.val!=t.right.val) &&
                    isSubtree(s.left,t.left) && isSubtree(s.right,t.right)
            ){
                return true;

            }

        // Recursively check for all subtree of s while keeping t as same.
        if(isSubtree(s.left,t) || isSubtree(s.right,t))
            return true;

        return false;
    }


    public static void main(String[] args) {
        /**
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         *
         *    4
         *   / \
         *  1   2
         *
         */
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(2);
        a2.left = a4;
        a2.right = a5;
        a1.left = a2;
        a1.right = a3;

        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(1);
        TreeNode a8 = new TreeNode(2);
        a6.left = a7; a6.right = a8;

        System.out.println(isSubtree(a1, a6));


        /**
         *
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         *     /
         *    0
         *
         *    4
         *   / \
         *  1   2
         *
         */
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(5);
        TreeNode b4 = new TreeNode(1);
        TreeNode b5 = new TreeNode(2);
        TreeNode b51 = new TreeNode(0);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b5.left = b51;



        TreeNode b6 = new TreeNode(4);
        TreeNode b7 = new TreeNode(1);
        TreeNode b8 = new TreeNode(2);
        b6.left = b7;
        b6.right = b8;

        System.out.println(isSubtree(b1, b6));




    }





}