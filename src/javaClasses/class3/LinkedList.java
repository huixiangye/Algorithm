package javaClasses.class3;

import java.util.List;

/**
 * Created by yehuixiang on 8/3/18.
 */
class ListNode{
    public int value;
    public ListNode next;
    public ListNode(int value){
        this.value = value;
        next = null;
    }
}

public class LinkedList {
    //length()
    public int length(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //get()
    public ListNode get(ListNode head,int index){
        ListNode cur = head;
        while(index > 0 && cur != null){
            cur = cur.next;
            index--;
        }

        return cur;
    }

    //appendHead
    public ListNode appendHead(ListNode head, int value){
        ListNode newHead = new ListNode(4);
        newHead.next = head;
        return newHead;
    }

    //appendTail
    public ListNode appendTail(ListNode head,int value){
        //head == null
        if(head == null){
            return new ListNode(value);
        }

        //head != null
        ListNode prev = head;
        while(prev.next != null){
            prev = prev.next;
        }
        prev.next = new ListNode(value);
        return head;
    }

    //remove()
    public ListNode remove(ListNode head, int value){
        //head == null
        if(head == null){
            return null;
        }else if(head.value == value){
            return head.next;
        }

        //head != null
        ListNode cur = head;
        while(cur.next != null && cur.next.value != value){
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}
