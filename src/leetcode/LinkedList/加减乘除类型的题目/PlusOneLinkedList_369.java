package leetcode.LinkedList.加减乘除类型的题目;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/12/18.
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 */
public class PlusOneLinkedList_369 {
    public static ListNode plusOne(ListNode head) {
        if(head == null){
            return head;
        }

        //ListNode dummy = new ListNode(0);
        ListNode newHead = reverseList(head);

        ListNode run = newHead;
        int count = 1;
        while(run.next != null){
            int num = run.val + count;
            count = num /10;
            run.val = num %10;
            run = run.next;
        }

        int num = run.val + count;
        count = num / 10;
        run.val = num % 10;

        if(count == 1) {
            run.next = new ListNode(1);
        }

        return reverseList(newHead);

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode res = PlusOneLinkedList_369.plusOne(head);

        while(res!=null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.print("null");
    }
}
