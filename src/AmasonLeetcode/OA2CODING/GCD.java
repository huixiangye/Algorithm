package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * GCD Greatest Common Divisor
 * 就是给一个数组找这些数的最大公约数

 */
public class GCD {
    public static int GCD(int[] input) {
        if(input.length == 1) return input[0];
        int res = input[0];
        for(int i = 1; i < input.length; i++) {
            res = helper(res, input[i]);
        }
        return res;
    }

    private static int helper(int a, int b) {
        if(b == 0) return a;
        return helper(b, a%b);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {9,6,12,24};
        System.out.println(GCD(input));
    }


}
