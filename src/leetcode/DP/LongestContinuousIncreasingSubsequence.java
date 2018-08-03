package leetcode.DP;

/**
 * Created by yehuixiang on 7/15/18.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] M = new int[nums.length];
        int global_max = 1;
        M[0] = 1;

        for(int i =1; i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                M[i] = M[i-1]+1;
            }else{
                M[i] = 1;
            }

            global_max = Math.max(global_max,M[i]);
        }

        return global_max;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,3,5,4,7};
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        System.out.print(longestContinuousIncreasingSubsequence.findLengthOfLCIS(test));
    }

}
