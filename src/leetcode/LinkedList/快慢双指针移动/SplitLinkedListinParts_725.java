package leetcode.LinkedList.快慢双指针移动;

import leetcode.LinkedList.ListNode;

/**
 * Created by yehuixiang on 8/20/18.
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

 The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

 The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

 Return a List of ListNode's representing the linked list parts that are formed.

 Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 Example 1:
 Input:
 root = [1, 2, 3], k = 5
 Output: [[1],[2],[3],[],[]]
 Explanation:
 The input and each element of the output are ListNodes, not arrays.
 For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 The first element output[0] has output[0].val = 1, output[0].next = null.
 The last element output[4] is null, but it's string representation as a ListNode is [].
 Example 2:
 Input:
 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 Explanation:
 The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 */
public class SplitLinkedListinParts_725 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode curr = root;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        curr = root;

        if(len <= k){
            int count = 0;
            while(curr != null){
                res[count++] = curr;
                ListNode tmp = curr.next;
                curr.next = null;
                curr = tmp;
            }
        }else{
            int count = len /k;
            int remain = len % k ;
            for(int j = 0; j < k; j++) {
                res[j] = curr;
                //System.out.println(j + "," + curr.val);
                int t = count + (remain > 0 ? 1 : 0);
                for(int i = 0; i < t - 1; i++) {
                    curr = curr.next;
                }
                if(curr == null) break;
                ListNode tmp = curr.next;
                curr.next = null;
                curr = tmp;
                remain --;
            }
        }
        return res;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode[] res = SplitLinkedListinParts_725.splitListToParts(head,4);

        for(int i = 0; i<res.length;i++){
            ListNode temp = res[i];
            while(temp != null){
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
