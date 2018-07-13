package others;

/**
 * Created by yehuixiang on 6/29/18.
 */

/*
1.	Recursion 与计算的结合
Q1 a^b

1. 0 as the denominator
2. 1/3 as an integer ?? or float
3 0^0

 */
public class a_pow_b {
    public double power(int a, int b){

        if(a == 0 && b <= 0){
            return -1;
        }else if(b<0){
            return 1/(double)pow(a,b);
        }else{
            return (double) pow(a,b);
        }

    }

    public int pow(int a, int b){
        if(b == 0)
            return 1;
        int half_result = pow(a,b/2);
        if(b%2 == 0)
            return half_result * half_result;
        else
            return half_result*half_result*a;
    }

    public static void main(String args[]){
        a_pow_b test = new a_pow_b();
        System.out.println(test.power(2,10));
        System.out.println(test.power(2,-10));
        System.out.println(test.power(0,20));
        System.out.println(test.power(0,-20));
    }

}
