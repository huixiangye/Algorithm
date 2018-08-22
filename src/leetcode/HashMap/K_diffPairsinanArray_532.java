package leetcode.HashMap;

import java.util.Arrays;

/**
 * Created by yehuixiang on 8/22/18.

 * Given an array of integers and an integer k,
 you need to find the number of unique k-diff pairs in the array.

 * Here a k-diff pair is defined as an integer pair (i, j),
 where i and j are both numbers in the array and their absolute difference is k.

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.
 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).

 */
//滑动窗口思想
public class K_diffPairsinanArray_532 {
    public static int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for(int start = 0; start<nums.length; start++){
            if(start>0 && nums[start] == nums[start-1])
                continue;

            int end = start+1;
            while(end<nums.length){
                int abs = Math.abs(nums[start] - nums[end]);
                if(abs == k){
                    res++;
                    break;
                }else if(abs < k){
                    end++;
                }else{
                    break;
                }
            }
        }

        return res;

    }

    public static void main(String[] args){
        int[] test = {3, 1, 4, 1, 5};
        System.out.println(K_diffPairsinanArray_532.findPairs(test,2));
    }
}
