package leetcode.LinkedList.DeepCopy;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/4/18.
 *
 A linked list is given such that each node contains
 an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x){
        this.label = x;
    }
}


public class CopyListwithRandomPointer_138 {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy,newNode;
        RandomListNode cur = head;

        while(cur != null){

            if(map.containsKey(cur)){
                newNode = map.get(cur);
            }else{
                newNode = new RandomListNode(cur.label);
                map.put(cur,newNode);
            }

            pre.next = newNode;

            if(cur.random != null){
                if(map.containsKey(cur.random)){
                    newNode.random = map.get(cur.random);
                }else{
                    newNode.random = new RandomListNode(cur.random.label);
                    map.put(cur.random,newNode.random);
                }
            }

            pre = newNode;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        RandomListNode head = new RandomListNode(1);
        head.random = new RandomListNode(2);
        head.next = new RandomListNode(2);
        head.next.random = new RandomListNode(3);
        head.next.next = new RandomListNode(3);
        //head.next.next.random = new RandomListNode(8);

        RandomListNode testNode = head;
        System.out.println("the Original list");
        while (testNode != null) {
            if(testNode.random == null){
                System.out.print("nodeValue: " + testNode.label + " randomValue: null" + " --> ");
            }else {
                System.out.print("nodeValue: " + testNode.label + " randomValue: " + testNode.random.label + " --> ");
            }
            testNode = testNode.next;

        }
        System.out.println();

        CopyListwithRandomPointer_138 test = new CopyListwithRandomPointer_138();
        RandomListNode temp1 = test.copyRandomList(head);
        System.out.println("the Copy list");
        while (temp1 != null) {
            if(temp1.random == null){
                System.out.print("nodeValue: "+temp1.label + " randomValue: null"+" --> ");
            }else{
                System.out.print("nodeValue: "+temp1.label + " randomValue: "+temp1.random.label +" --> ");
            }

            temp1 = temp1.next;
        }
        System.out.println();
    }

}
