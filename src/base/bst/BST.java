package base.bst;


import base.List.LinkListQueue;

import java.util.*;

public class BST<E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left, right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BST(){
        size = 0;
        root = null;
    }

    public void add(E e){
//        if(root == null){
//            root = new Node (e);
//            size ++;
//        }else{
//            add(root, e);
//        }

        root = add(root, e);
    }


     Node add(Node node, E e){

//        if(node.e.equals(e)){
//            return ;
//        }if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return ;
//        }else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size ++;
//            return ;
//        }

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) > 0 ){
            node.right = add(node.right, e);
        }else if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }
        return node;
    }


    public boolean contains(E e ){
        return contains(root,e);
    }

    private boolean contains(Node node, E e ){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) > 0){
            return contains(node.right, e);
        }else{
            return contains(node.left, e);
        }
    }


    //前中后序遍历方法
    //前序
    public void perOrder(){
        perOrder(root);
    }

    public void perOrder(Node node){

//        if(node == null){
//            return ;
//        }

        if(node != null){
            System.out.println(node.e);
            perOrder(node.left);
            perOrder(node.right);
        }
    }

    //前序递归转化为非递归--使用栈转化
    public void perNormalOrder(){
        Stack<Node> stack = new Stack();
        //todo 自定义实现的数据报空指针
//        LinkListStack<Node> stack = new LinkListStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
//            System.out.println(stack.toString());
            Node tempNode = stack.pop();
            System.out.println(tempNode.e);
            if(tempNode.right != null){
                stack.push(tempNode.right);
            }
            if(tempNode.left != null){
                stack.push(tempNode.left);
            }
        }
    }


    //中序
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return ;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    //后序
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

//    public void levelOrder(){
//        levelOrder(root);
//    }

    // 借助队列数据结构 实现层序遍历
    public void levelOrder(){
        LinkListQueue<Node> queue = new LinkListQueue<>();
        queue.enQueue(root);
        while(!queue.isEmpty()){
            Node cur = queue.deQueue();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.enQueue(cur.left);
            }
            if(cur.right != null){
                queue.enQueue(cur.right);
            }
        }
    }

    private Node minNode(){
        if(root == null){
            throw new IllegalArgumentException("bst is empty");
        }
        return minNode(root);
    }

    public Node minNode(Node node){
        if(node.left == null){
            return node;
        }
        return minNode(node.left);
    }

    private Node maxNode(){
        if(root == null){
            throw new IllegalArgumentException("bst is empty!");
        }
        return maxNode(root);
    }

    public Node maxNode(Node node){
        if(node.right == null){
            return node;
        }
        return maxNode(node.right);
    }

    public Node delMaxNode(){
//        if(root == null){
//            throw new IllegalArgumentException("bst is empty!");
//        }
        Node ret = maxNode();
        root = delMaxNode(root);
        return ret;
    }

    //删除以node为根节点最大的元素
    private Node delMaxNode(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = delMaxNode(node.right);
        return node;
    }

    public Node delMinNode(){
//        if(root == null){
//            throw new IllegalArgumentException("bst is empty!");
//        }
        Node ret = minNode();
        root = delMinNode(root);
        return ret;
    }

    //删除以node为根节点最小的元素
    private Node delMinNode(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.right = delMaxNode(node.right);
        return node;
    }

    //删除元素
    public Node remove(Node node, E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return  node;
        }else{
            //右子树
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            Node succor = minNode(node.right);
            succor.right = delMinNode(node.right);
            succor.left = node.left;

            node.left = node.right = null;

            return succor;
        }
    }




    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        return generateToString(root, 0, res);
    }

    private String generateToString(Node node, int depth, StringBuilder res){
        if(node == null ){
            res.append(getString(depth)).append("null\n");
            return null;
        }
        depth ++;
        res.append(getString(depth)).append(node.e).append("\n");
        generateToString(node.left,depth, res);
        generateToString(node.right,depth, res);
        return res.toString();
    }

    private String getString(int size){
        StringBuilder res = new StringBuilder();
        for(int i = size; i > 0; i--){
            res.append("--");
        }
        return res.toString();
    }



}
