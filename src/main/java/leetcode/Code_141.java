package leetcode;

/**
 * @author: nj
 * @date: 2020-03-08 19:01
 * @version: 0.0.1
 */
public class Code_141 {
    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     *
     * Example 2:
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the first node.
     *
     *
     * Example 3:
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     *
     * Follow up:
     *
     * Can you solve it using O(1) (i.e. constant) memory?
     */

    public static  boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode  tempNext = head;
        while (tempNext != null){
//            System.out.println("--"+tempNext.toString());
            if(tempNext == tempNext.next){
                return true;
            }
            ListNode t1 = head;
            while(t1 != tempNext){
//                System.out.println("++"+t1.toString());
                if(t1 == tempNext.next){
                    return true;
                }
                t1 = t1.next;
            }
            tempNext = tempNext.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        return slow == fast? true : false;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(hasCycle(l1));

        ListNode l11 = new ListNode(12);
        ListNode l21 = new ListNode(212);
        l11.next = l21;
        l21.next = l11;
        System.out.println(hasCycle(l11));


        ListNode l111 = new ListNode(12113);
        l111.next = l111;
        System.out.println(hasCycle(l111));

        ListNode a = new ListNode(12);
        ListNode b = new ListNode(212);
        a.next = b;

        System.out.println(hasCycle(a));

    }


}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }

    @Override
    public String toString() {
        return val+"";
    }
}