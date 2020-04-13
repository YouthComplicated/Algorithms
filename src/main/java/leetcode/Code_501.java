package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-10 16:11
 * @version: 0.0.1
 */
public class Code_501 {

    /**
     *
     * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the
     * given BST.
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * For example:
     * Given BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     *
     *
     * return [2].
     *
     * Note: If a tree has more than one mode, you can return them in any order.
     *
     * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion
     * does not count).
     *
     *
     *
     * 统计BST中元素出现的最多的元素，可能最高次数有重复
     *
     *
     * 1、BST特点
     *
     *   左子树大于右子树
     *
     *
     * 常规思路：使用map 遍历统计，统计遍历所有节点
     *
     *
     */

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int staticsMax = statics(root, map, 0);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == staticsMax){
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer i : list){
            result[k++] = i;
        }
        return result;
    }

    public static int statics(TreeNode node, Map<Integer, Integer> map, int max){
        if(node != null) {
            Integer orDefault = map.getOrDefault(node.val, 0) + 1;
            map.put(node.val,orDefault);
            if(max < orDefault){
                max = orDefault;
            }
            max = Math.max(statics(node.left, map, max), statics(node.right, map, max));
        }
        return max;
    }


    Map<Integer, Integer> map;
    int max = 0;
    private void inorder1(TreeNode node){
        if(node.left!=null) inorder1(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max = Math.max(max, map.get(node.val));
        if(node.right!=null) inorder1(node.right);
    }


    /**
     *
     * 特点 : 左子树大于右子树 所以不必 max(left,right)
     * 采取max(left,left.lfet)
     */
    public int[] findMode1(TreeNode root) {
        inorder(root);
        mode_count=max_count;
        count_=0;
        inorder(root);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;

    }

    int val_=0;
    int count_=0;
    int mode_count=Integer.MAX_VALUE;
    int max_count=0;
    List<Integer> ans=new ArrayList();

    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        visit(root.val);
        inorder(root.right);
    }

    private void visit(int val){
        if(count_ >0 && val==val_){
            ++count_;
        }else{
            val_=val;
            count_=1;
        }
        if(count_>max_count){
            max_count=count_;
        }
        if(count_==mode_count){
            ans.add(val);
        }

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node2.left = node3;
        node1.right = node2;


        System.out.println(Arrays.toString(findMode(node1)));


    }





}