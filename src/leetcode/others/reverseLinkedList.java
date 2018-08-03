package leetcode.others;

/**
 * Created by yehuixiang on 7/2/18.
 */
//输入一个链表，反转链表后，输出链表的所有元素。
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}
public class reverseLinkedList {

    public ListNode Reverse1(ListNode head){
        if(head == null)
            return null;

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
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        //list: 1 2 3 4
        reverseLinkedList test = new reverseLinkedList();
        ListNode res = test.Reverse1(node1);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
