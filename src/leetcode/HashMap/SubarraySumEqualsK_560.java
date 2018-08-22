package leetcode.HashMap;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/22/18.
 * Given an array of integers and an integer k,
 you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 */
public class SubarraySumEqualsK_560 {
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for(int start = 0; start<nums.length;start++){
            int sum = 0;
            for(int end = start;end<nums.length;end++){
                sum = sum+nums[end];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args){
        int[] test = {1,1,1};
        System.out.println(SubarraySumEqualsK_560.subarraySum1(test,3));
        System.out.println(SubarraySumEqualsK_560.subarraySum2(test,2));
    }
}
