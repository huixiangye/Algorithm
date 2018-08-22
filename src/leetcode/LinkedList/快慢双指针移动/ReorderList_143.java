package leetcode.LinkedList.快慢双指针移动;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/12/18.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You may not modify the values in the list's nodes, only nodes itself may be changed.

 Example 1:

 Given 1->2->3->4, reorder it to 1->4->2->3.
 Example 2:

 Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */

//思路还是比较简单, 先找中点,然后中点后的链表断开reverse一下,然后按照新规则相连
public class ReorderList_143 {
    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        //find the middle point
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while (head != null && head2 != null){
            ListNode post1 = head.next;
            ListNode post2 = head2.next;

            head.next = head2;
            head2.next = post1;

            head = post1;
            head2 = post2;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ReorderList_143.reorderList(head);
        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }
}
