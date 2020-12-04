package base.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-05-11 21:29
 * @version: 0.0.1
 */
public class JosephList {

    Node head;

    public void contruct(int m){

        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(new Node(i));
        }
        head = list.get(0);
        int i = 1;
        for (; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(i - 1).next = list.get(0);

    }

    public void print(int n){
        Node prev = head;
        Node temp = prev.next;
        int t = 1;
        while (temp != null){
            t++;
            if(t == n){
                System.out.println(temp.val);
                prev.next = temp.next;
                temp = temp.next;
                t = 0;
            }else{
                prev =  prev.next;
                temp = temp.next;
            }
            if(prev == temp){
                break;
            }
        }

        System.out.println(prev.val);

    }

    public static void main(String[] args) {

        JosephList josephList = new JosephList();

        josephList.contruct(7);
        josephList.print(3);

    }





}


class SNode{

    int val;
    SNode sNode;

    public SNode(int val) {
        this.val = val;
    }
}