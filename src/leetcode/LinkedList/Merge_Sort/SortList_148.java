package leetcode.LinkedList.Merge_Sort;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/9/18.
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 思路:
 首先哪些排序是nlogn的？ merge和quick sort   还有heap sortList
 quick sort空间复杂度为1， in place      merge sort需要n的额外空间    head sort 可以是O(1)的   merge sort需要额外的空间来merge
 bucket sort  redix 排序是O(n)  不过有条件的

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class SortList_148 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);

    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = SortList_148.sortList(head);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
