package leetcode.others;

/**
 * Created by yehuixiang on 7/3/18.
 */

/*

Sort a linked list in O(n log n) time using constant space complexity.

merge sort and quick sort
首先哪些排序是nlogn的？ merge和quick sort   还有heap sortList
quick sort空间复杂度为1， in place      merge sort需要n的额外空间    head sort 可以是O(1)的   merge sort需要额外的空间来merge
bucket sort  redix 排序是O(n)  不过有条件的

 */



public class SortList {
    public ListNode mergeSortList(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = mergeSortList(mid.next);

        mid.next = null;

        ListNode left = mergeSortList(head);

        return merge(left,right);


    }

    public ListNode findMiddle(ListNode head){

        if(head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(5);
        node1.next.next.next.next = new ListNode(4);

        SortList sortList = new SortList();
        ListNode temp = sortList.mergeSortList(node1);
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
