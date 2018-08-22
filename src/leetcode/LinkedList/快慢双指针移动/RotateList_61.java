package leetcode.LinkedList.快慢双指针移动;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/20/18.
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL

 */
public class RotateList_61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        // count numbers
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }

        int num = k % count;

        if(num == 0){
            return dummy.next;
        }

        num = count - num;

        // divide to two groups
        ListNode fast = dummy;
        while(fast != null && num > 0){
            fast = fast.next;
            num--;
        }


        ListNode head2 = fast.next;
        fast.next = null;

        ListNode res = new ListNode(0);
        res.next = head2;

        while(head2.next != null){
            head2 = head2.next;
        }

        head2.next = dummy.next;

        return res.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);


        ListNode res =RotateList_61.rotateRight(head,3);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
    }
}
