package AmasonLeetcode.OA2CODING;

import java.util.Arrays;

/**
 * Created by yehuixiang on 7/27/18.
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */


public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int res = 0;

        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<min){
                    min = Math.abs(sum-target);
                    res = sum;
                }

                if(sum<target){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] test = new int[]{-1, 2, 1, -4};
        System.out.print(ThreeSumClosest.threeSumClosest(test,1));
    }
}
