package AmasonLeetcode.OA2CODING.oa2面试题;

import java.util.*;

/**
 * Created by yehuixiang on 7/28/18.
 */
public class minWindow {
    public ArrayList<Integer> maxSlidingWindow(int numberOfDays, ArrayList<Integer> temp, int windowSize) {
        if (temp == null || numberOfDays <= 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < temp.size(); i++) {
            // remove numbers out of range windowSize
            while (!q.isEmpty() && q.peek() < i - windowSize + 1) {
                q.poll();
            }

            // remove larger numbers in range windowSize
            while (!q.isEmpty() && temp.get(q.peekLast()) > temp.get(i)) {
                q.pollLast();
            }

            q.offer(i);
            if(i >= windowSize - 1){
                res.add(temp.get(q.peek()));
            }

        }

        return res;
    }

    public static void main(String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(2);
        test.add(12);
        test.add(11);
        test.add(-5);
        minWindow minWindow = new minWindow();
        System.out.print(minWindow.maxSlidingWindow(5,test,2));
    }
}
