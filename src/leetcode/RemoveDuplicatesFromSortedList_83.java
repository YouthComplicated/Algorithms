package leetcode;

public class RemoveDuplicatesFromSortedList_83 {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * Example 1:
     *
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */

    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ){
            return head;
        }
        int x = head.val;
        ListNode tempNode = head, result = head.next;
        while (result != null) {
            System.out.println(result.val);
            if (x == result.val) {
                result = result.next;
                if(result == null){
                    tempNode.next = null;
                }
            } else {
                tempNode.next = result;
                tempNode = tempNode.next;
                x = result.val;
                result = result.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode nextNode = currNode.next;

        while (nextNode != null) {
            if (nextNode.val == currNode.val) {
                currNode.next = nextNode.next;
                nextNode = currNode.next;
            } else {
                currNode = nextNode;
                nextNode = currNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList_83 a = new RemoveDuplicatesFromSortedList_83();
//        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(1);
//        ListNode a3 = new ListNode(2);
//        a1.next = a2;
//        a2.next = a3;
//        ListNode node = a.deleteDuplicates(a1);


        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(2);
        ListNode b4 = new ListNode(3);
        ListNode b5 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode node1 = a.deleteDuplicates(b1);

        System.out.println(node1);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


     static class ListNode {
          int val;
          ListNode next;
          public ListNode(int x) { val = x; }
      }

}
