package leetcode.LinkedList.指针的翻转操作;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/21/18.
 */
public class ReverseLinkedList_206 {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;

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

        ListNode res = ReverseLinkedList_206.reverseList(head);

        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
