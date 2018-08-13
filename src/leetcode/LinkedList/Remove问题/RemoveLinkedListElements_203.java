package leetcode.LinkedList.Remove问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/12/18.
 * Remove all elements from a linked list of integers that have value val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements_203 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode res =RemoveLinkedListElements_203.removeElements(head,6);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
