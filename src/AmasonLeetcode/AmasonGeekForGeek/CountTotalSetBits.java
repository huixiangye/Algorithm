package AmasonLeetcode.AmasonGeekForGeek;

import java.util.Scanner;

/**
 * Created by yehuixiang on 7/10/18.
 * Find the sum of all bits from numbers 1 to N.

 Input:

 The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is N.

 Output:

 Print the sum of all bits.

 Constraints:

 1 ≤ T ≤ 100
 1 ≤ N ≤ 1000

 Example:

 Input:
 2
 4
 17

 Output:
 5
 35

 Explanation:
 An easy way to look at it is to consider the number, n = 4:
 0 0 0 = 0
 0 0 1 = 1
 0 1 0 = 1
 0 1 1 = 2
 1 0 0 = 1
 Therefore , the total number of bits is 5
 */
public class CountTotalSetBits {
    static int totalSetBits(int n){
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    static int help(int n){
        int count=0;
        for(int i=1;i<=n;i++)
            count+=totalSetBits(i);
        return count;
    }
    public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            System.out.println(help(n));
        }
    }
}
