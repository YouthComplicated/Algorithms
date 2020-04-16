package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-04-15 12:53
 * @version: 0.0.1
 */
public class Code_589 {


    /**
     * Given an n-ary tree, return the preorder traversal of its nodes' values.
     *
     * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by
     * the null value (See examples).
     *
     *
     * Follow up:
     *
     * Recursive solution is trivial, could you do it iteratively?
     *
     *
     * Example 1:
     *
     *
     *
     * Input: root = [1,null,3,2,4,null,5,6]
     * Output: [1,3,5,6,2,4]
     * Example 2:
     *
     *
     *
     * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
     *
     *
     * Constraints:
     *
     * The height of the n-ary tree is less than or equal to 1000
     * The total number of nodes is between [0, 10^4]
     *
     *
     * 非二叉树的  根左右(中序遍历)
     *            左右根
     *            没有左根右形式
     *
     *
     */

    static List<Integer> result = new ArrayList<>();

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        List<Node> children = root.children;
        if(children != null){
            for (Node node : children) {
                preorder(node);
            }
        }
        return result;
    }

    /**
     * 前序  左右根
     * @param root
     * @return
     */
    public static List<Integer> postorder(Node root) {
        if(root == null){
            return result;
        }
        List<Node> children = root.children;
        if(children != null){
            for (Node node : children) {
//                result.add(node.val);
                postorder(node);
            }
        }
        result.add(root.val);
        return result;
    }


    public static void main(String[] args) {
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        List<Node> list = new ArrayList<>();
        list.add(a5);list.add(a6);


        Node a2 = new Node(2);
        Node a4 = new Node(4);
        Node a3 = new Node(3,list);
        List<Node> list1 = new ArrayList<>();
        list1.add(a3); list1.add(a2);list1.add(a4);

        Node a1 = new Node(1,list1);


//        System.out.println(preorder(a1));
        System.out.println(postorder(a1));

    }


}