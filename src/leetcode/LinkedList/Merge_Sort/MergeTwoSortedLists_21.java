package leetcode.LinkedList.Merge_Sort;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/4/18.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists_21 {
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode tempL1 = l1;
        System.out.println("list l1:");
        while (tempL1 != null){
            System.out.print(tempL1.val+"-->");
            tempL1 = tempL1.next;
        }

        System.out.println();
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode tempL2 = l1;
        System.out.println("list l2:");
        while (tempL2 != null){
            System.out.print(tempL2.val+"-->");
            tempL2 = tempL2.next;
        }

        System.out.println();
        System.out.println("the merged list:");
        ListNode res = MergeTwoSortedLists_21.mergeTwoLists(l1,l2);

        while (res != null){
            System.out.print(res.val+"-->");
            res = res.next;
        }

    }
}
