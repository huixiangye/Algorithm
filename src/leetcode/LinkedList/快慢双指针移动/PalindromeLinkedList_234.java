package leetcode.LinkedList.快慢双指针移动;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/20/18.
 * Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 */

//思路: 找中点,reverse一下,对比
public class PalindromeLinkedList_234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(PalindromeLinkedList_234.isPalindrome(head));
    }

}
