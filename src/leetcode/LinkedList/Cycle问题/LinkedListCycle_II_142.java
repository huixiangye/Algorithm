package leetcode.LinkedList.Cycle问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/4/18.
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */

//这题没什么好说的,涉及到一个数学问题,背一下就行了。思路就是先找环,然后再找那个点。
public class LinkedListCycle_II_142 {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        //find the cycle first
        while(fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        //find the node
        while(head != slow.next){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
    public static void main(String[] args) {
        //there is a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println("this list has a cycle shuold return true");
        System.out.println(LinkedListCycle_II_142.detectCycle(head).val);

        //there is no cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println("this list has no cycle shuold return false");
        System.out.println(LinkedListCycle_II_142.detectCycle(head1));
    }
}
