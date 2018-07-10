import java.util.Locale;

/**
 * Created by yehuixiang on 7/3/18.
 */
/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode p1 = reverseList(l1);
        ListNode p2 = reverseList(l2);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int sum = 0;
        while(p1 != null || p2 != null){
            if(p1 != null){
                sum = sum + p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                sum = sum + p2.val;
                p2 = p2.next;
            }

            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }

        if(sum == 1){
            curr.next = new ListNode(1);
        }
        return reverseList(dummy.next);
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode res = addTwoNumbersII.addTwoNumbersII(node1,node2);

        while(res!=null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.print("null");
    }
}
