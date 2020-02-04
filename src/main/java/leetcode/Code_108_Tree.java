package leetcode;

/**
 * @author: nj
 * @date: 2020-01-05 12:25
 * @version: 0.0.1
 */
public class Code_108_Tree {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */


    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return rescurse(nums, 0, len- 1);

    }

    public TreeNode rescurse(int[] nums, int low, int high){
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode tnode = new TreeNode(nums[mid]);
        tnode.left = rescurse(nums, low, mid - 1);
        tnode.right = rescurse(nums, mid + 1, high);
        return tnode;
    }

    public static void main(String[] args) {

    }

}


