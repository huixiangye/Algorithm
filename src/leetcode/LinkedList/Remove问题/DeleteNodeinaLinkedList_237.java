package leetcode.LinkedList.Remove问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/12/18.
 * Given linked list -- head = [4,5,1,9], which looks like following:

 4 -> 5 -> 1 -> 9
 Example 1:

 Input: head = [4,5,1,9], node = 5
 Output: [4,1,9]
 Explanation: You are given the second node with value 5, the linked list
 should become 4 -> 1 -> 9 after calling your function.
 Example 2:

 Input: head = [4,5,1,9], node = 1
 Output: [4,5,9]
 Explanation: You are given the third node with value 1, the linked list
 should become 4 -> 5 -> 9 after calling your function.
 */
public class DeleteNodeinaLinkedList_237 {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        head.next = node1;
        ListNode node2 = new ListNode(1);
        head.next.next = node2;
        ListNode node3 = new ListNode(9);
        head.next.next.next = node3;

        DeleteNodeinaLinkedList_237.deleteNode(node1);
        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }
}
