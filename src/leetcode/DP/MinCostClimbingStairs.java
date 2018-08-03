package leetcode.DP;

/**
 * Created by yehuixiang on 7/15/18.
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        //dp[n]:= min cost to climb to n-th step
        //dp[n] = min(dp[n-1]+cost[n-1],dp[n-2]+cost[n-2])
        //return dp[n]
        int length = cost.length + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[length - 1];
    }

    public static void main(String[] args){
        int[] test = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.print(MinCostClimbingStairs.minCostClimbingStairs(test));
    }
}
