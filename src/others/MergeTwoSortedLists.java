package others;

/**
 * Created by yehuixiang on 7/3/18.
 */

//Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
    /*
    Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

     */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        while(l1 != null){
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while(l2 != null){
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(8);
        node2.next.next = new ListNode(10);
        node2.next.next.next = new ListNode(11);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode temp = mergeTwoSortedLists.mergeTwoLists(node1, node2);

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
