package leetcode.LinkedList.指针的翻转操作;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/21/18.
 */
public class PartitionList_86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        ListNode point = dummy;

        while(head != null){
            if(head.val < x){
                head = head.next;
                pre = pre.next;
            }else{
                dummy.next = head;
                dummy = dummy.next;
                pre.next = head.next;
                head = head.next;
            }
        }

        pre.next = point.next;
        dummy.next = null;
        return res.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        ListNode res = PartitionList_86.partition(head,2);
        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
