package leetcode.LinkedList.Cycle问题;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/4/18.
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:    a1 → a2
               ↘
                c1 → c2 → c3
              ↗
 B:b1 → b2 → b3

 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists_160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if any List is null return null
        if(headA == null || headB == null){
            return null;
        }

        //calculate the listA length
        ListNode curA = headA;
        int countA = 0;
        while(curA != null){
            curA = curA.next;
            countA++;
        }
        curA = headA;

        //calculate the listB length
        ListNode curB = headB;
        int countB = 0;
        while(curB != null){
            curB = curB.next;
            countB++;
        }
        curB = headB;

        //find the interact node C1
        if(countA >= countB){
            for(int i = 0; i < countA - countB ; i++){
                curA = curA.next;
            }
        }else{
            for(int i = 0; i < countB - countA ; i++){
                curB = curB.next;
            }
        }

        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(3);
        headB.next.next = headA.next.next.next;
        headB.next.next.next = headA.next.next.next.next;

        ListNode res = IntersectionofTwoLinkedLists_160.getIntersectionNode(headA,headB);
        System.out.println("the intersectionNode value is: "+ res.val);
    }
}
