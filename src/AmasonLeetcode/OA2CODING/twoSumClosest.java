package AmasonLeetcode.OA2CODING;

import java.util.Arrays;

/**
 * Created by yehuixiang on 7/26/18.
 */
public class twoSumClosest {
    public static int twoSumC(int[] nums, int target){
        if(nums == null || nums.length <2){
            return -1;
        }

        if(nums.length == 2){
            return target-nums[0]-nums[1];
        }

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length-1;
        int minDiff = Integer.MAX_VALUE;

        while(l<r){
            int sum = nums[l] + nums[r];
            int diff = Math.abs(sum - target);

            if(diff == 0){

                return 0;
            }

            if(diff<minDiff){
                minDiff = diff;
            }

            if(sum>target){
                r--;
            }else {
                l++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args){
        int[] test = new int[]{20,2,1,3,19,8,3,6};
        System.out.print(twoSumClosest.twoSumC(test,9));
    }
}
