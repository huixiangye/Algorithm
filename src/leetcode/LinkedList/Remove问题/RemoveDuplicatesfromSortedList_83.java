package leetcode.LinkedList.Remove问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/9/18.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList_83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }


        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode res = RemoveDuplicatesfromSortedList_83.deleteDuplicates(head);

        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
