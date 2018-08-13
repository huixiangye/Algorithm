package leetcode.LinkedList.Remove问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/9/18.
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII_82 {
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while(p.next != null && p.next.next != null){

            if(p.next.val == p.next.next.val){
                int sameNum = p.next.val;
                while(p.next != null && p.next.val == sameNum){
                    p.next = p.next.next;
                }
            }else{
                p = p.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode res = RemoveDuplicatesfromSortedListII_82.deleteDuplicates(head);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
