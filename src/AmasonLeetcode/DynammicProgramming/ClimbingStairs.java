package AmasonLeetcode.DynammicProgramming;

/**
 * Created by yehuixiang on 7/15/18.
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
                 //迭代做法
         if(n<=1) return 1;

         int oneStep = 1;
         int twoStep = 1;
         int res = 0;

         for(int i = 2; i <= n; i++){
             res = oneStep + twoStep;
             twoStep = oneStep;
             oneStep = res;
         }

         return res;
    }

    public static void main(String[] args){
        System.out.println(ClimbingStairs.climbStairs(3));
        System.out.println(ClimbingStairs.climbStairs(5));
    }
}
