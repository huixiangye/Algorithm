package leetcode.LinkedList.Merge_Sort;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/9/18.
 * Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class InsertionSortList_147 {
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode run = dummy;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;

            while(run.next != null && cur.val > run.next.val){
                run = run.next;
            }

            cur.next = run.next;
            run.next = cur;
            cur = next;
            run = dummy;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = InsertionSortList_147.insertionSortList(head);

        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
