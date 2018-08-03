package leetcode.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yehuixiang on 6/29/18.
 */

/*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

class RandomListNode {

    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;

        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }



        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);

        }

        return dummy.next;
    }



    public static void main(String[] args){
        RandomListNode head = new RandomListNode(1);
        head.random = new RandomListNode(2);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.random = new RandomListNode(3);

        CopyListwithRandomPointer test = new CopyListwithRandomPointer();
        test.copyRandomList1(head);

    }
}
