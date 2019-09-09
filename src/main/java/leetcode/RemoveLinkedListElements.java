package leetcode;

public class RemoveLinkedListElements {

    /**
     * 不使用虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode = null;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode preNode = head;
        while(preNode.next != null){
            if(preNode.next.val == val){
//               ListNode delNode = head.next;
//                preNode.next = delNode.next;
//                delNode = null;
                preNode.next =preNode.next.next;
            }else{
                preNode = preNode.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        ListNode yummyHead = new ListNode(-1);
        yummyHead.next = head;
        ListNode curNode = yummyHead;
        while(curNode.next != null){
            if(curNode.next.val == val){
                curNode.next =curNode.next.next;
            }else{
                curNode = curNode.next;
            }
        }
        return yummyHead.next;
    }

    /**
     * 使用递归算法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null){
            return null;
        }
//        ListNode res  = removeElements3(head.next, val);
//        if(head.val == val){
//            return res;
//        }else{
//            head.next = res;
//            return head;
//        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static int sum(int arr[], int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l+1);
    }

  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

}
