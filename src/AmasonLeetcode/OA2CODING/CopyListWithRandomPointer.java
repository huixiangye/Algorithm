package AmasonLeetcode.OA2CODING;

import java.util.HashMap;


/**
 * Created by yehuixiang on 7/26/18.
 */

class RandomListNode {

    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;


        while (head != null) {
            //copy the head value
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            //copy the random node value
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

        return dummy.next;
    }



    public static void main(String[] args){
        RandomListNode head = new RandomListNode(1);
        head.random = new RandomListNode(2);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.random = new RandomListNode(3);

        CopyListWithRandomPointer test = new CopyListWithRandomPointer();
        RandomListNode temp1 = test.copyRandomList1(head);
        RandomListNode temp2 = test.copyRandomList1(head);

        while(temp1.random != null){
            System.out.print("random value " + temp1.random.label + " ");
            temp1 = temp1.next;
        }
        System.out.println();
        while(temp2 != null){
            System.out.print("node value "+temp2.label + " ");
            temp2 = temp2.next;
        }

    }
}
