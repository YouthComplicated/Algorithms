package leetcode;

/**
 * @author: nj
 * @date: 2020-03-15 20:33
 * @version: 0.0.1
 */
public class Code_234 {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     */

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return  true;
        }
        ListNode prev  = null;
        ListNode curr,next;
        curr = head;
        ListNode aa = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (head != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            curr = curr.next;
        }
        return true;

    }


    public static ListNode getNode(ListNode head){
//        if(head == null){
//            return  null;
//        }
//        ListNode prev  = null;
//        ListNode curr,next;
//        curr = head;
//        while(curr != null){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return curr;
        return null;
    }


    public static boolean isPalindrome11(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverseList(slow);
        slow = head;
        while (slow != null && reverse != null)
        {
            if (slow.val != reverse.val)
                return false;
            slow = slow.next;
            reverse = reverse.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(isPalindrome11(a1));


    }
}