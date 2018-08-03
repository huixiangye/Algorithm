package leetcode.others;

/**
 * Created by yehuixiang on 7/2/18.
 */

//Given a linked list, determine if it has a cycle in it.

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}
public class LinkedListCycle1 {
    public boolean hasCycle(ListNode1 head) {
        if(head == null|| head.next == null){
            return false;
        }

        ListNode1 slow = head;
        ListNode1 fast = head.next;

        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args){
        ListNode1 node1 = new ListNode1(1);
        node1.next = new ListNode1(2);
        node1.next.next = new ListNode1(3);
        node1.next.next.next = node1.next.next;


        LinkedListCycle1 test = new LinkedListCycle1();
        System.out.println(test.hasCycle(node1));

        ListNode1 node2 = new ListNode1(1);
        node2.next = new ListNode1(2);
        node2.next.next = new ListNode1(3);
        node2.next.next.next = new ListNode1(4);
        System.out.println(test.hasCycle(node2));


    }
}
