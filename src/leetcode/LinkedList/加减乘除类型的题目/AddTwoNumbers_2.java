package leetcode.LinkedList.加减乘除类型的题目;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/12/18.\
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;

        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum = sum /10;
        }

        if(sum == 1){
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode res = AddTwoNumbers_2.addTwoNumbers(node1,node2);

        while(res!=null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.print("null");
    }
}
