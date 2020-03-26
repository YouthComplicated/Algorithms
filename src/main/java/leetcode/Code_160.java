package leetcode;

/**
 * @author: nj
 * @date: 2020-03-09 20:50
 * @version: 0.0.1
 */
public class Code_160 {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     * For example, the following two linked lists:
     *
     *
     * begin to intersect at node c1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     *
     *
     * Example 2:
     *
     *
     * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Reference of the node with value = 2
     * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     *
     *
     * Example 3:
     *
     *
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: null
     * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     *
     *
     * Notes:
     *
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode temANode = headA;
        while ( temANode.next != null){
            temANode = temANode.next;
        }
        //construct a cycle
        temANode.next = headB;
        while(headA != null){
            ListNode tempB = headB;
            while (tempB != null){
                if(headA == tempB){
                    temANode.next = null;
                    return headA;
                }
                tempB = tempB.next;
                if(headB == tempB){
                    break;
                }
            }
            headA = headA.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a= a!=null ? a.next : headB;
            b= b!=null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode a1 = new ListNode(3);
        a1.next = l4;


//        ListNode aa = getIntersectionNode(l1, a1);

        System.out.println("xxx");

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(1);
        ListNode b5 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;




        ListNode aa = getIntersectionNode(b1, b4);

        System.out.println(111);

    }

}