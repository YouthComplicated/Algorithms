package leetcode;

/**
 * @author: nj
 * @date: 2020-04-28 20:31
 * @version: 0.0.1
 */
public class Code_876 {


    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     *
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     *
     * Note:
     *
     * The number of nodes in the given list will be between 1 and 100.
     *
     *
     *
     */


    public static ListNode middleNode(ListNode head) {
        int len = 1;
        ListNode temp = head;
        while ((head = head.next) != null){
            len ++;
        }
        len = len / 2 - 1;
        while (len >= 0){
            temp = temp.next;
            len --;
        }

        return temp;

    }

    public ListNode middleNode1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /**
     * 跑的快
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;


        ListNode listNode = middleNode(l1);

        System.out.println(middleNode(l1));
    }



}