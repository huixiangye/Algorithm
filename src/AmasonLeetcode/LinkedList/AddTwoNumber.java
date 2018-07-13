package AmasonLeetcode.LinkedList;

/**
 * Created by yehuixiang on 7/13/18.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;

        if(p1 == null){
            return p2;
        }

        if(p2 == null){
            return p1;
        }

        while(p1 != null || p2 != null){
            if(p1 !=null){
                sum += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }

            curr.next = new ListNode(sum%10);
            curr = curr.next;
            sum = sum/10;
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

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode res = addTwoNumber.addTwoNumbers(node1,node2);

        while(res!=null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.print("null");
    }
}
