package AmasonGeekForGeek;

import java.util.Scanner;

/**
 * Created by yehuixiang on 7/10/18.
 * Generate all prime numbers between two given numbers.

 Input:

 The first line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing two space separated integers m and n.
 Output:

 For every test case print all prime numbers p such that m <= p <= n, space separated. Separate the answers for each test case by a new line.

 Constraints:
 1<=T<=60
 1 <= m <= n <= 100000,
 n - m <= 100000

 Example:

 Input:

 2

 1 10

 3 5

 Output:

 2 3 5 7

 3 5
 */
public class FindPrimeNumbersInARange {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        while(a-->0)
        {
            int b=sc.nextInt();
            int c=sc.nextInt();
            for(int i=b;i<=c;i++)
            {
                int flag=0;
                for(int j=1;j<=((i/2));j++)
                {
                    if(i%j==0){flag++;if(flag==2)break;}
                }
                if(flag==1)System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
