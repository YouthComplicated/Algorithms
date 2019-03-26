package leetcode;

public class ConvertArrayBinaryTree_108 {

    /**
     * Given an array where elements are sorted in ascending order,
     * convert it to a height balanced BST.(二叉搜索树)
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following
     * height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */

    /**
     * 二分法进行添加  二分法两种方法的实现
     * 根的选取，如果为偶数则为:num/2+1
     *              为奇数则为:num/2
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high =  nums.length - 1;
        int mid = low + (high - low)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        //left  low  high = mid
        high = mid-1;
        treeNode.left = new TreeNode(low+(high-low)/2);

        low = mid+1;
        treeNode.right = new TreeNode(low+(high-low)/2);




        int len = nums.length;
        TreeNode root = null;
        int left,right;
        if(len % 2 == 0){
            root = new TreeNode(nums[len/2 + 1]);
            left = len/2;
            root.left = new TreeNode(left);
        }else{
            root = new TreeNode(nums[len/2]);
            right = len/2 + 1;
        }
        return null;
    }



    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
