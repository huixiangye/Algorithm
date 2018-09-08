package leetcode.BinarySearch.复杂二分法;

import leetcode.HashMap.HashSet.LongestPalindrome_409;

import java.util.Arrays;

/**
 * Created by yehuixiang on 9/4/18.
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence_300 {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int result = 0;
        Arrays.fill(dp,1);

        for(int i = 0; i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            result = Math.max(result,dp[i]);
        }

        return result;
    }

    public static void main(String[] args){
        int[] test = {10,9,2,5,3,7,101,18};
        System.out.println(LongestIncreasingSubsequence_300.lengthOfLIS(test));
    }
}
