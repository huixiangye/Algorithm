package AmasonGeekForGeek;

import java.util.Scanner;

/**
 * Created by yehuixiang on 7/10/18.
 * *School Problem's Submission isn't counted in score!

 Given street of houses (a row of houses), each house having some amount of money kept inside; now there is a thief who is going to steal this money but he has a constraint/rule that he cannot steal/rob two adjacent houses. Find the maximum money he can rob.

 Input:

 The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is N and money.

 Output:

 Print maximum money he can rob.

 Constraints:

 1 ≤ T ≤ 100
 1 ≤ money ≤ 100
 1 ≤ N ≤ 1000

 Example:

 Input:

 2

 5 10

 2 12

 Output:

 30

 12
 */
public class MaximumMoney {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int sum = 0;
            int house = sc.nextInt();
            int money = sc.nextInt();
            for(int i = 0; i<house;i = i+2){
                sum = sum+money;
            }
            System.out.println(sum);
        }
    }
}
