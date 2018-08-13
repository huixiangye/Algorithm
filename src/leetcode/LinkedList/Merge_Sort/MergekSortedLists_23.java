package leetcode.LinkedList.Merge_Sort;

import leetcode.LinkedList.ListNode;
import leetcode.others.MergeSort;

/**
 * Created by yehuixiang on 8/4/18.
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        return mergeHelper(lists,0,lists.length-1);
    }

    public static ListNode mergeHelper(ListNode[] lists, int left, int right){
        if(left > right){
            return null;
        }

        if(left == right){
            return lists[left];
        }

        int mid = (left + right)/2;

        ListNode leftResult = mergeHelper(lists,left,mid);
        ListNode rightResult = mergeHelper(lists,mid+1,right);

        return mergeTwoLists(leftResult, rightResult);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else{
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            if(l1 != null){
                cur.next = l1;
            }

            if(l2 != null){
                cur.next = l2;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args){
        ListNode[] test = new ListNode[3];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        test[0] = head1;
        test[1] = head2;
        test[2] = head3;

        ListNode res = MergekSortedLists_23.mergeKLists(test);

        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }

    }
}
