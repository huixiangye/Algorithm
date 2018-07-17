package AmasonLeetcode.DynammicProgramming;

/**
 * Created by yehuixiang on 7/15/18.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //nums: -2, 1, -3, 4, -1, 2, 1, -5, 4
        //f:    -2, 1, -2, 4,  3, 5, 6,  1, 5

        //induction rule: f[i] = f[i-1]>0 ? nums[i]+f[i-1] : nums[i]
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int global_max = nums[0];

        for(int i = 1; i<nums.length;i++){
            if(f[i-1]>0) {
                f[i] = f[i - 1] + nums[i];
            }else{
                f[i] = nums[i];
            }

            global_max = Math.max(global_max,f[i]);
        }

        return global_max;

    }

    public static void main(String[] args){
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.print(maximumSubarray.maxSubArray(test));
    }
}
