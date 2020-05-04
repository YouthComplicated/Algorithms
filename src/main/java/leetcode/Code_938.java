package leetcode;

/**
 * @author: nj
 * @date: 2020-05-03 16:59
 * @version: 0.0.1
 */
public class Code_938 {

    /**
     *
     */
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val >= L && root.val <= R){
            sum += root.val;
        }
        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
        return sum;
    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        if (root.val >= L && root.val <= R)
            return root.val + rangeSumBST1(root.right, L, R) + rangeSumBST1(root.left, L, R);
        else if (root.val < L)
            return rangeSumBST1(root.right, L, R);
        else
            return rangeSumBST1(root.left, L, R);
    }

//    public void inOrder(TreeNode root, int L, int R, int sum){
//        if(root == null){
//            return 0;
//        }
//        if(root.val >= L && root.val <= R){
//            sum += root.val;
//        }
//        sum = rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
//        return sum;
//    }

}