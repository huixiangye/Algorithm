package leetcode.LinkedList.指针的翻转操作;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/21/18.
 * Given a linked list, swap every two adjacent nodes and return its head.

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.

 */
public class SwapNodesinPairs_24 {
    public static  ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(head != null){
            ListNode sec = head.next;
            if(sec == null) break;

            pre.next = head.next;
            head.next = sec.next;
            sec.next = head;
            pre = head;
            head = head.next;

        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = SwapNodesinPairs_24.swapPairs(head);
        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }

}
