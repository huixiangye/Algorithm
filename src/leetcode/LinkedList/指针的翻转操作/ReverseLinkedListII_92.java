package leetcode.LinkedList.指针的翻转操作;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/21/18.
 */
public class ReverseLinkedListII_92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode fast = curr;

        for(int i = 0;i<m-1; i++){
            fast = fast.next;
        }

        ListNode first = fast, second = fast.next;
        curr = second;
        ListNode pre = null;

        for(int i = 0; i < n-m+1; i++){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        first.next = pre;
        second.next = curr;
        if(m == 1) return first.next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode res = ReverseLinkedListII_92.reverseBetween(head ,1,2);
        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
