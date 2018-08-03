package AmasonLeetcode.AmasonGeekForGeek;

import java.util.Scanner;

/**
 * Created by yehuixiang on 7/10/18.
 * Reverse a 32 bit given number.
 Input:
 The first line of input consists number of the test cases. Each test case contains a single 32 bit integer.

 Output:
 For each test case, print the reverse of integer in newline.

 Constraints:
 1<=T<=100
 0<=x<=4294967295

 Example:

 Input:
 2
 1
 5

 Output:
 2147483648
 2684354560
 */
public class ReverseBit {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            String a = Integer.toBinaryString(n);
            String b = reverse(a);
            long x = Long.parseLong(b,2);
            System.out.println(x);
        }
    }

    public static String reverse(String a){
        String b="";
        for(int i=a.length()-1;i>=0;i--){
            b+=String.valueOf(a.charAt(i));
        }
        for(int i=a.length();i<32;i++){
            b+="0";
        }
        return b;
    }
}
