package leetcode.LinkedList.Cycle问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/4/18.
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?


 */
public class LinkedListCycle_1_141 {
    public static boolean hasCycle(ListNode head) {
        //the corner case the list is null or the list just has one element
        if(head == null || head.next == null){
            return false;
        }
        //two pointers for the loop
        ListNode fast = head.next;
        ListNode slow = head;

        //if there is a cycle, the fast and the slow will meet in some where
        while(slow != fast){
            //if there is not a cycle, the  fast or fast.next will be null
            //so return false;
            if(fast == null || fast.next == null){
                return false;
            }
            //move the pointers
            slow = slow.next;
            fast = fast.next.next;
        }
        //if fast meet slow,means there is a cycle.
        return true;
    }

    public static void main(String[] args){
        //there is a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println("this list has a cycle shuold return true");
        System.out.println(LinkedListCycle_1_141.hasCycle(head));

        //there is no cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println("this list has no cycle shuold return false");
        System.out.println(LinkedListCycle_1_141.hasCycle(head1));
    }
}
