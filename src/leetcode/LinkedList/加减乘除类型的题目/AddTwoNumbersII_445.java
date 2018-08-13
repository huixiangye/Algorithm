package leetcode.LinkedList.加减乘除类型的题目;

import leetcode.LinkedList.ListNode;

import java.util.Stack;

/**
 * Created by yehuixiang on 8/12/18.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII_445 {
    public static ListNode addTwoNumbers_withoutStacks(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            if(carry == 1 && l1 == null && l2 == null) head.next = new ListNode(1);
        }
        return reverseList(dummy.next);
    }
    private static ListNode reverseList(ListNode curr) {
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode addTwoNumbers_withStack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);

        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode res1 = AddTwoNumbersII_445.addTwoNumbers_withoutStacks(node1,node2);

        while(res1!=null){
            System.out.print(res1.val + "-->");
            res1 = res1.next;
        }
        System.out.print("null");

        System.out.println();

        ListNode node3 = new ListNode(7);
        node3.next = new ListNode(2);
        node3.next.next = new ListNode(4);
        node3.next.next.next = new ListNode(3);

        ListNode node4 = new ListNode(5);
        node4.next = new ListNode(6);
        node4.next.next = new ListNode(4);
        ListNode res2 = AddTwoNumbersII_445.addTwoNumbers_withStack(node3,node4);

        while(res2!=null){
            System.out.print(res2.val + "-->");
            res2 = res2.next;
        }
        System.out.print("null");
    }
}
