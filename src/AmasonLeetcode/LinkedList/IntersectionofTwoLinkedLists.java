package AmasonLeetcode.LinkedList;

/**
 * Created by yehuixiang on 7/13/18.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int countA = 0;
        int countB = 0;

        if(pA == null || pB == null){
            return null;
        }

        while(pA != null){
            countA++;
            pA = pA.next;
        }
        pA = headA;

        while(pB != null){
            countB++;
            pB = pB.next;
        }
        pB = headB;

        if(countA>=countB){
            for(int i = 0; i<countA-countB;i++){
                pA = pA.next;
            }
        }else{
            for (int i = 0; i<countB-countA;i++){
                pB = pB.next;
            }
        }

        while(pA != null && pB != null){
            if( pA.val == pB.val)
                return pA;

            pA = pA.next;
            pB = pB.next;
        }

        return  null;
    }

    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(7);
        headB.next = new ListNode(4);
        headB.next.next = new ListNode(5);

        IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new IntersectionofTwoLinkedLists();
        System.out.print(intersectionofTwoLinkedLists.getIntersectionNode(headA,headB).val);
    }
}
