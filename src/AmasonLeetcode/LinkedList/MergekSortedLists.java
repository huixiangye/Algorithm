package AmasonLeetcode.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yehuixiang on 7/13/18.
 *
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //the except case
        if(lists == null || lists.length == 0){
            return null;
        }
        int size = lists.length;

        Queue<ListNode> heap = new PriorityQueue<>(size, new ListNodeComparator());

        for(int i = 0;i<size;i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!heap.isEmpty()){
            ListNode temp = heap.poll();
            head.next = temp;
            head = head.next;
            if(temp.next != null){
                heap.offer(temp.next);
            }
        }

        return dummy.next;
    }

    private class ListNodeComparator implements Comparator<ListNode> {

        public int compare(ListNode o1, ListNode o2){
            assert o1 != null && o2 !=null;
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{head1,head2,head3};
        MergekSortedLists mergekSortedLists = new MergekSortedLists();
        ListNode res = mergekSortedLists.mergeKLists(lists);

        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
