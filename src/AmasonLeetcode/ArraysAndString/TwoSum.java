package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/14/18.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //brute solution
        if(nums == null || nums.length == 0){
            return null;
        }

        int slow = 0;

        while(slow < nums.length){
            int temp = target - nums[slow];
            int fast = slow+1;
            while(fast <nums.length){
                if(temp == nums[fast])
                    return new int[]{slow,fast};
                fast++;
            }

            slow++;
        }

        return null;
    }

    public static void main(String[] args){
        int[] test = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(test,9);
        for(int i = 0; i < res.length;i++){
            System.out.print(res[i]+',');
        }
    }
}
