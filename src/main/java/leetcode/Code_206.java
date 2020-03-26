package leetcode;

/**
 * @author: nj
 * @date: 2020-03-15 17:11
 * @version: 0.0.1
 */
public class Code_206 {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     */

    public static ListNode reverseList(ListNode head) {

        if(head == null) {
            return null;
        }
        ListNode dummyNode = null;
        ListNode tmp;
        while(head != null) {
            tmp = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = tmp;
        }
        return dummyNode;


//        if(head == null || head.next == null) return head;
//        ListNode prev = null;
//        //prev.next = head;
//
//        ListNode curr, next;
//        curr = head;
//        while(curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//
//        }
//        return prev;

    }

    public static void main(String[] args) {

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        ListNode b5 = new ListNode(5);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode listNode = reverseList(b1);
        System.out.println(listNode);

    }


}