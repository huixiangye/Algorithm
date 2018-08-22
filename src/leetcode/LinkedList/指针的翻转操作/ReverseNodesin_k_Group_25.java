package leetcode.LinkedList.指针的翻转操作;

import leetcode.LinkedList.ListNode;

/**
 *
 * Created by yehuixiang on 8/21/18.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesin_k_Group_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null) {
            head = reverseNextK(head, k);
        }

        return dummy.next;
    }

    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1
    private ListNode reverseNextK(ListNode head, int k) {
        // check there is enought nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }

        // reverse
        ListNode n1 = head.next;
        ListNode prev = head, curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        n1.next = curt;
        head.next = prev;
        return n1;
    }
}
