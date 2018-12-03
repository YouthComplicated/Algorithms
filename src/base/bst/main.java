package base.bst;

public class main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] array = {5,1,6,8,4,3,2};
        int[] array = {5,3,6,8,4,2};
        for(int i = 0; i < array.length; i ++){
            bst.add(array[i]);
        }
        //System.out.println(bst.toString());

//        System.out.println("前序遍历");
//        bst.perOrder();
//        System.out.println("普通前序遍历");
//        bst.perNormalOrder();
//        System.out.println("删除最大元素");
//        bst.delMaxNode();
//        System.out.println("层序遍历");
//        bst.levelOrder();

//        System.out.println("中序遍历");
//        bst.inOrder();

        BST<Integer> bst1 = new BST<>();
        int[] array1 = {7,5,10,4,6,8,13,2,3,9,11,19};
        for(int i = 0; i < array1.length; i ++){
            bst1.add(array1[i]);
        }
        System.out.println("层序遍历");
        bst1.levelOrder();
        bst1.delMaxNode();
        System.out.println("=================");
        bst1.levelOrder();
    }
}
