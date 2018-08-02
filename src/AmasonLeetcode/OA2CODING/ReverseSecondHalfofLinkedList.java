package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 */


public class ReverseSecondHalfofLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        //因为中间也需要变，所以要添加dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //找到中间的位置了slow 右侧开始反转
        ListNode pre = null;
        ListNode cur = slow.next;

        while(cur != null){
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ReverseSecondHalfofLinkedList list = new ReverseSecondHalfofLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        //ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //five.next = six;
        list.reverseList(one);
        ListNode p = one;
        while(p != null){
            System.out.print(p.val+" ");
            p = p.next;
        }
    }
}
