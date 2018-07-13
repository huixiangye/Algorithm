package AmasonLeetcode;

/**
 * Created by yehuixiang on 7/10/18.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode n1 = l1, n2 = l2;
        int sum = 0;
        while(n1 != null || n2 != null){
            if(n1 != null){
                sum = sum+n1.val;
                n1 = n1.next;
            }
            if(n2 != null){
                sum = sum + n2.val;
                n2 = n2.next;
            }

            curr.next = new ListNode(sum % 10);
            sum = sum/10;
            curr = curr.next;

        }

        if(sum == 1){
            curr.next = new ListNode(1);
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

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(node1,node2);

        while(res!=null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.print("null");
    }
}
