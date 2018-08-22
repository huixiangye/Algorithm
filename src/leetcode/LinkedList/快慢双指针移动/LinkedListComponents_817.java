package leetcode.LinkedList.快慢双指针移动;

import leetcode.LinkedList.ListNode;

import java.util.HashSet;

/**
 * Created by yehuixiang on 8/21/18.
 * We are given head, the head node of a linked list containing unique integer values.

 We are also given the list G, a subset of the values in the linked list.

 Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

 Example 1:

 Input:
 head: 0->1->2->3
 G = [0, 1, 3]
 Output: 2
 Explanation:
 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 Example 2:

 Input:
 head: 0->1->2->3->4
 G = [0, 3, 1, 4]
 Output: 2
 Explanation:
 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */
public class LinkedListComponents_817 {
    public static int numComponents(ListNode head, int[] G) {
        if(head == null){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< G.length; i++){
            set.add(G[i]);
        }

        int counter = 0;
        boolean found = false;

        while(head != null){
            if(set.contains(head.val)){
                if(!found){
                    counter++;
                    found = true;
                }else{
                    head = head.next;
                }
            }else{
                head = head.next;
                found = false;
            }
        }

        return counter;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        int[] g = {0,1,3};
        System.out.println(LinkedListComponents_817.numComponents(head,g));
    }
}
