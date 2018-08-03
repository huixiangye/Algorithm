package leetcode.others;

/**
 * Created by yehuixiang on 7/3/18.
 */
/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);

        ListNode curr = head;
        dummy.next = curr;
        int counter = 0;

        while(curr != null){

            counter++;
            curr = curr.next;

        }

        counter = counter-n;
        curr = dummy;
        while(counter > 0){
            counter--;
            curr = curr.next;

        }

        curr.next = curr.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);


        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        ListNode temp = removeNthNodeFromEndofList.removeNthFromEnd(node1,2);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
