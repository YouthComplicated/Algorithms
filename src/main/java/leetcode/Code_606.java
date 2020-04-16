package leetcode;


/**
 * @author: nj
 * @date: 2020-04-15 20:58
 * @version: 0.0.1
 */
public class Code_606 {
    /**
     * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
     *
     * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
     * pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     *
     * Example 1:
     * Input: Binary tree: [1,2,3,4]
     *        1
     *      /   \
     *     2     3
     *    /
     *   4
     *
     * Output: "1(2(4))(3)"
     *
     * Explanation: Originallay it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs.
     * And it will be "1(2(4))(3)".
     * Example 2:
     * Input: Binary tree: [1,2,3,null,4]
     *        1
     *      /   \
     *     2     3
     *      \
     *       4
     *
     * Output: "1(2()(4))(3)"
     *
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
     *
     *
     *
     * 节点问题
     * 叶子节点: null
     *
     * 递归中如控制，如果节点的左孩子==null 右孩子 != null 必需拼接()
     *
     *
     *
     * 以下解法有问题， 原因：4 和 3 无法控制括号的拼接
     *
     *
     */


    static StringBuilder sb = new StringBuilder();
    public static String tree2str(TreeNode t) {
        if(t == null){
            return null;
        }
        System.out.println(t.val);
        sb.append(t.val);

        if(t.left == null && t.right != null){
            sb.append("()(");
        }else if(t.left == null && t.right == null){
//            sb.append(")");
            sb.append(")");
        }else{
            sb.append("(");
        }

        tree2str(t.left);

        tree2str(t.right);

//        if(t.left == null && t.right != null){
//            sb.append(")");
//        }else if(t.left == null && t.right == null){
//            //do noting
//            sb.append(")(");
//        }else{
//            sb.append(")");
//        }

        sb.append(")");

        return sb.toString();
    }


    private String tree2str11(TreeNode root) {
        if(root == null){
            return "";
        }
        helper(root);
        return sb.toString();
    }

    public void helper(TreeNode root){
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return ;
        }
        if (root.left != null){
            sb.append("(");
            tree2str(root.left);
            sb.append(")");
        }
        if (root.right != null){
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            tree2str(root.right);
            sb.append(")");
        }
    }


    public String tree2str1(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str1(t.left);
        String right = tree2str1(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }


    private void helper(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            sb.append("(");
            helper(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }


    public static void main(String[] args) {


        //1(2(4())3())   Output: "1(2(4))(3)"
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        b1.left = b2;
        b2.left = b4;
        b1.right = b3;
        System.out.println(tree2str(b1));



        //1(2(4())3())   Output: "1(2()(4))(3)" 左节点的() 可以去掉
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;
        a2.right = a4;
//        System.out.println(tree2str(a1));


    }










}