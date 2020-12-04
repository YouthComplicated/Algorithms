package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-10-24 10:50
 * @version: 0.0.1
 */
public class ReserveLinkNode {


    /**
     * 单链表反转
     *
     * 1 -   》  2   -》3
     *
     *
     */
    public  void reserve(LinkNode node){

        if(node == null){
            return;
        }
        LinkNode head = node;
        LinkNode next = node.next ;
        head.next = null;
        while (next != null){
            LinkNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }

        while (head != null){
            System.out.println(head.getVal());
            head = head.next;
        }

//        LinkNode next = node.next;





    }

    public ReserveLinkNode() {
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        node1.next = node2;
        node2.next = node3;


        ReserveLinkNode reserveLinkNode =  new ReserveLinkNode();
//        reserveLinkNode.reserve(node1);

        String s = "abcabcbb";
        int start = -1,res = 1;
        Set<Character> set =  new HashSet();

        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                start += 1;
                res = Math.max(res, i - start);
                System.out.println(res+"start"+start+"i"+i);
            }else{
                set.add(s.charAt(i));
            }
        }




    }

}




class LinkNode{
    private  int val;

    public LinkNode next;

    public LinkNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
