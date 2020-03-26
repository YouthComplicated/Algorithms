package leetcode;

/**
 * @author: nj
 * @date: 2020-03-19 20:59
 * @version: 0.0.1
 */
public class Code_237 {


    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     *
     * Given linked list -- head = [4,5,1,9], which looks like following:
     *
     *
     * Example 1:
     *
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
     * Example 2:
     *
     * Input: head = [4,5,1,9], node = 1
     * Output: [4,5,9]
     * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
     *
     *
     * Note:
     *
     * The linked list will have at least two elements.
     * All of the nodes' values will be unique.
     * The given node will not be the tail and it will always be a valid node of the linked list.
     * Do not return anything from your function.
     */

    public static void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            if (curr.next != null) {
                curr.val = curr.next.val;
                prev = curr;
                curr = curr.next;
            } else {
                if (prev != null) {
                    prev.next = null;
                } else {
                    //not gonna happen
                }
                break;
            }
        }
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        deleteNode(a2);
        System.out.println(1111);
    }




}