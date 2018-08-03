package leetcode.others;

/**
 * Created by yehuixiang on 5/14/18.
 */
public class Fibonacci {

    //recursion
    public int fibo(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        //System.out.print(" " +fibo(n-1) + fibo(n-2) );
        return fibo(n-1) + fibo(n-2);
    }

    //without using any collection
    public int fibo2(int n){
        int a = 0;
        int b = 1;
        int c;

        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        for(int i = 2;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }

        return b;

    }


    public static void main(String[] args){
        Fibonacci test1 = new Fibonacci();
        System.out.println(test1.fibo(9));
        System.out.println(test1.fibo2(9));
    }
}
