package AmasonLeetcode.OA2CODING;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by yehuixiang on 7/26/18.
 */
public class windowMinimum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove larger numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] > nums[i]) {
                //这里如果将< 改成 > 就是每个window中的最大值, < 则是window中的最小值
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;

    }

    public static void main(String[] args){
        int[] test = new int[]{4, 2, 12, 11, -5};
        System.out.print(Arrays.toString(windowMinimum.maxSlidingWindow(test,2)));
    }
}
