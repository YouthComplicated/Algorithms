package base.List;

/**
 * @author: nj
 * @date: 2020-05-11 20:55
 * @version: 0.0.1
 */
public class DoubleLinkList {

    Node head = new Node(0);


    //添加节点
    public void add(Node node){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void print(){
        Node temp = head.next;
        if(temp == null){
            System.out.println("链表为空！");
        }
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }


    public void delete(int val){
        Node temp = head.next;
        boolean isFind = false;
        while (temp != null){
            if(temp.val == val){
                isFind = true;
                break;
            }
            temp = temp.next;
        }


        if(isFind){
            //从前往后
            temp.prev.next = temp.next;
            //从后往前
            if(temp.next != null){
                temp.next.prev =  temp.prev;
            }
        }else{
            System.out.println("未找到该元素！");
        }


    }

    public static void main(String[] args) {

        DoubleLinkList list = new DoubleLinkList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.print();
        System.out.println();
        list.delete(3);
        list.print();


    }


}

class Node{


    int val;

    Node prev;

    Node next;

    public Node(int val) {
        this.val = val;
    }
}